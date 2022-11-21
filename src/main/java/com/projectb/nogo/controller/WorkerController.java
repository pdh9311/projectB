package com.projectb.nogo.controller;

import com.projectb.nogo.domain.Worker;
import com.projectb.nogo.domain.WorkerInfo;
import com.projectb.nogo.dto.LocalCodeDto;
import com.projectb.nogo.dto.WorkerJoinForm;
import com.projectb.nogo.dto.WorkerLoginForm;
import com.projectb.nogo.service.WorkerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("worker")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerService workerService;

    @GetMapping("/join")
    public String workerJoinForm() {
        return "worker/join";
    }

    @PostMapping("/join")
    public String workerJoin(@Valid WorkerJoinForm workerJoinForm) {
        log.info("workerJoinDto = {}", workerJoinForm);
        WorkerInfo workerInfo = new WorkerInfo(workerJoinForm);
        Worker worker = new Worker(workerJoinForm);
        workerService.save(workerInfo, worker);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String workerLoginForm() {
        return "worker/login";
    }

    @PostMapping("/login")
    public String workerLogin(WorkerLoginForm workerLoginForm) {
        WorkerInfo workerInfo = workerService.login(workerLoginForm).get();
        log.info("workerInfo = {}", workerInfo);
        return "redirect:/";
    }

    @GetMapping("/main")
    public String workerMainForm() {
        return "worker/main";
    }

    @PostMapping("/main")
    public String workerMain(LocalCodeDto localCodeDto) {
        log.info("logCodeDto = {}", localCodeDto);
        return "redirect:/worker/main";
    }

    @PostMapping("/main/apply")
    @ResponseBody
    public String apply(@RequestBody LocalCodeDto localCodeDto) {
        // 세션에서 근로자 정보 가져와서 선택한 지역에 지원하기 ..
        log.info("localCodeDto={}", localCodeDto);
        Boolean result = workerService.applyJob(localCodeDto);
        if (result == false) {
            return "fail";
        }
        return "ok";
    }
}
