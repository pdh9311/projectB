package com.projectb.nogo.controller;

import com.projectb.nogo.domain.Kakao;
import com.projectb.nogo.domain.KakaoProfile;
import com.projectb.nogo.dto.KakaoUserToken;
import com.projectb.nogo.dto.LoginEmployerDto;
import com.projectb.nogo.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping
    public String login(Model model) {
        model.addAttribute("kakaoLoginUrl", Kakao.createAuthRequestUrl());
        return "login";
    }

    @RequestMapping("/auth/kakao")
    public String authKakao(@RequestParam("code") String code, HttpSession session) {
        KakaoUserToken kakaoUserToken = loginService.getKakaoUserToken(code);
        KakaoProfile kakaoProfile = loginService.getKakaoUserInfo(kakaoUserToken);
//        loginServiceImpl.saveWorker(kakaoUserToken);

        // worker 객체로 변경 필요
        //session.setAttribute(SessionConst.WORKER, kakaoUserToken);
        if (kakaoProfile == null) {
            return "redirect:/login";
        }
        return "redirect:/";
    }

    @PostMapping("/employer")
    public String loginEmployer(@Valid LoginEmployerDto loginEmployerDto) {
        if (!loginService.isMatchingEmployerIdPw(loginEmployerDto)) {
            return "redirect:/login";
        }
        return "redirect:/";
    }
}

