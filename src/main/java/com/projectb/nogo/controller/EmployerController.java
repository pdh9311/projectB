package com.projectb.nogo.controller;

import com.projectb.nogo.domain.Employer;
import com.projectb.nogo.domain.EmployerInfo;
import com.projectb.nogo.dto.EmployerJoinDto;
import com.projectb.nogo.dto.EmployerLoginDto;
import com.projectb.nogo.service.EmployerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("employer")
@RequiredArgsConstructor
public class EmployerController {

    private final EmployerService employerService;

    @GetMapping("/join")
    public String employerJoinForm() {
        return "employer/join";
    }

    @PostMapping("/join")
    public String employerJoin(@Valid EmployerJoinDto employerJoinDto) {
        log.info("EmployerJoinDto = {}", employerJoinDto);
        EmployerInfo employerInfo = new EmployerInfo(employerJoinDto);
        Employer employer = new Employer(employerJoinDto);
        employerService.save(employerInfo, employer);
        log.info("Employer = {}", employer);
        log.info("EmployerInfo = {}", employerInfo);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String employerLoginForm() {
        return "employer/login";
    }

    @PostMapping("/login")
    public String employerLogin(EmployerLoginDto employerLoginDto) {
        log.info("employerLoginDto = {}", employerLoginDto);
        EmployerInfo employerInfo = employerService.login(employerLoginDto).get();
        log.info("EmployerInfo = {}", employerInfo);
        return "redirect:/";
    }
}
