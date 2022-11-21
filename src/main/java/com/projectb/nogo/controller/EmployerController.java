package com.projectb.nogo.controller;

import com.projectb.nogo.domain.Employer;
import com.projectb.nogo.domain.EmployerInfo;
import com.projectb.nogo.domain.WorkerInfo;
import com.projectb.nogo.dto.EmployDto;
import com.projectb.nogo.dto.EmployerJoinForm;
import com.projectb.nogo.dto.EmployerLoginForm;
import com.projectb.nogo.dto.LocalCodeDto;
import com.projectb.nogo.service.EmployerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public List<WorkerInfo> getApplicants(@RequestBody LocalCodeDto localCodeDto) {
        log.info("localCodeDto = {}", localCodeDto);
        List<WorkerInfo> applicants = employerService.findApplicants(localCodeDto);
        log.info("Applicants = {}", applicants);
        return applicants;
    }

    @PostMapping("/main/doEmploy")
    @ResponseBody
    public String doEmploy(@RequestBody EmployDto employDto) {

        log.info("EmployDto = {}", employDto);

        // 고용자 정보는 세션에서 가져온다.

        // 고용 내역에 추가한다.
        Boolean result = employerService.addEmploy(employDto);
        if (result == false) {
            return "fail";
        }
        return "ok";
    }
}
