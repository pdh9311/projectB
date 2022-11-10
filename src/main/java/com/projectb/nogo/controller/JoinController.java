package com.projectb.nogo.controller;

import com.projectb.nogo.domain.Employer;
import com.projectb.nogo.dto.EmployerDto;
import com.projectb.nogo.service.JoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/join")
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @GetMapping("/employer")
    public String joinEmployer() {
        return "join/employer";
    }

    /**
     * 다음과 같은 가정을 두고 구현 해봐야하나?
     * EmployerDto에서 pw 와 rePw 값이 같지 않으면 error 로그를 남기고 에러 페이지로 보낸다.
     */
    @PostMapping("/employer")
    public String CompleteJoinEmployer(@ModelAttribute EmployerDto employerDto) {
        log.info("corporateDto={}", employerDto);
        Employer savedEmployer = joinService.save(employerDto);
        log.info("i = {}", savedEmployer.getI());
        return "redirect:/";
    }

    @GetMapping("/worker")
    public String joinWorkerPage() {
        return "join/worker";
    }
}
