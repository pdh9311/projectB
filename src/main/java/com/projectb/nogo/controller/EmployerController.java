package com.projectb.nogo.controller;

import com.projectb.nogo.domain.Employer;
import com.projectb.nogo.domain.EmployerInfo;
import com.projectb.nogo.dto.EmployerJoinDto;
import com.projectb.nogo.dto.EmployerLoginDto;
import com.projectb.nogo.service.EmployerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

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
        EmployerInfo employerInfo = new EmployerInfo(employerJoinDto);
        Employer employer = new Employer(employerJoinDto);
        employerService.save(employerInfo, employer);
        return "redirect:/employer/login";
    }

    @GetMapping("/login")
    public String employerLoginForm() {
        return "employer/login";
    }

    @PostMapping("/login")
    public String employerLogin(EmployerLoginDto employerLoginDto) {
        EmployerInfo employerInfo = employerService.login(employerLoginDto).get();
        // 세션 저장 (interceptor 에서 로그인 유지 필요)
        return "redirect:/";
    }

    @GetMapping("/main")
    public String employerMainForm() {
        return "employer/main";
    }

    @PostMapping("/main/sido")
    @ResponseBody
    public Map<String, String> sidoList() {
        return employerService.findSidoList();
    }

    @PostMapping("/main/sigungu/{code}")
    @ResponseBody
    public Map<String, String> sigunguList(@PathVariable String code) {
        return employerService.findSigunguList(code);
    }

    @PostMapping("/main/eupmyeondong/{code}")
    @ResponseBody
    public Map<String, String> eupmyeondongList(@PathVariable String code) {
        return employerService.findEupmyeondongList(code);
    }
}
