package com.projectb.nogo.controller;

import com.projectb.nogo.domain.Employer;
import com.projectb.nogo.domain.EmployerInfo;
import com.projectb.nogo.dto.EmployerJoinForm;
import com.projectb.nogo.dto.EmployerLoginForm;
import com.projectb.nogo.service.EmployerService;
import com.projectb.nogo.service.LocalCodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("employer")
@RequiredArgsConstructor
public class EmployerController {

    private final EmployerService employerService;
    private final LocalCodeService localCodeService;

    @GetMapping("/join")
    public String employerJoinForm() {
        return "employer/join";
    }

    @PostMapping("/join")
    public String employerJoin(@Valid EmployerJoinForm employerJoinForm) {
        EmployerInfo employerInfo = new EmployerInfo(employerJoinForm);
        Employer employer = new Employer(employerJoinForm);
        employerService.save(employerInfo, employer);
        return "redirect:/employer/login";
    }

    @GetMapping("/login")
    public String employerLoginForm() {
        return "employer/login";
    }

    @PostMapping("/login")
    public String employerLogin(EmployerLoginForm employerLoginForm) {
        EmployerInfo employerInfo = employerService.login(employerLoginForm).get();
        // 세션 저장 (interceptor 에서 로그인 유지 필요)
        return "redirect:/";
    }

    @GetMapping("/main")
    public String employerMainForm() {
        return "employer/main";
    }

    @PostMapping("/main/workerList")
    @ResponseBody
    public String getApplicants() {
//        employerService.findApplicants();
        return "abc";
    }
}
