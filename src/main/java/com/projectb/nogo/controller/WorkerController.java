package com.projectb.nogo.controller;

import com.projectb.nogo.dto.WorkerJoinDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("worker")
public class WorkerController {

    @GetMapping("/join")
    public String workerJoinForm() {
        return "worker/join";
    }

    @PostMapping("/join")
    public String workerJoin(WorkerJoinDto workerJoinDto) {
        log.info("workerJoinDto = {}", workerJoinDto);
        return "redirect:/";
    }
}
