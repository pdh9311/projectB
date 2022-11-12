package com.projectb.nogo.service;

import com.projectb.nogo.domain.KakaoProfile;
import com.projectb.nogo.dto.KakaoUserToken;
import com.projectb.nogo.dto.LoginEmployerDto;

public interface LoginService {

    // 카카오 인증 토근 발급
    KakaoUserToken getKakaoUserToken(String code);

    // 카카오 프로필 정보 가져오기
    KakaoProfile getKakaoUserInfo(KakaoUserToken kakaoUserToken);

    // 고용자 아이디로 조회해서 비밀번호 일치하는지 확인
    Boolean isMatchingEmployerIdPw(LoginEmployerDto loginEmployerDto);



}
