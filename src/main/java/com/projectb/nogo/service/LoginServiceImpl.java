package com.projectb.nogo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.projectb.nogo.domain.Kakao;
import com.projectb.nogo.domain.KakaoProfile;
import com.projectb.nogo.dto.KakaoUserToken;
import com.projectb.nogo.dto.LoginEmployerDto;
import com.projectb.nogo.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;

    @Override
    public KakaoUserToken getKakaoUserToken(String code) {
        String tokenRequestUrl = Kakao.createTokenRequestUrl(code);
        String line = null;
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(tokenRequestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
//            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            connection.setConnectTimeout(10000);  // 10초
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
            connection.disconnect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        KakaoUserToken kakaoUserToken = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            kakaoUserToken = objectMapper.readValue(sb.toString(), KakaoUserToken.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        log.info("kakaoUserToken info = {}", kakaoUserToken);
        return kakaoUserToken;
    }

    @Override
    public KakaoProfile getKakaoUserInfo(KakaoUserToken kakaoUserToken) {
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            URL url = new URL(Kakao.createKakaoUserProfileUrl());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + kakaoUserToken.getAccessToken());
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            connection.setConnectTimeout(10000);  // 10초
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
            connection.disconnect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info("kakao user profile = {}", sb);

        KakaoProfile kakaoProfile = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            kakaoProfile = objectMapper.registerModule(new JavaTimeModule()).readValue(sb.toString(), KakaoProfile.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return kakaoProfile;
    }

    public void saveWorker(KakaoUserToken kakaoUserToken) {
        // 사용자 정보로 조회해서 없으면 저장, 있으면 바로 리턴
    }

    @Override
    public Boolean isMatchingEmployerIdPw(LoginEmployerDto loginEmployerDto) {

        try {
            loginRepository.findByIdAndPw(loginEmployerDto);
            log.info("일치하는 아이디 와 비밀번호를 찾았습니다.");
            return true;
        } catch (DataAccessException e) {
            log.info("일치하는 아이디 비밀번호가 없습니다.");
            return false;
        }

    }

}
