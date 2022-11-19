package com.projectb.nogo.controller;


import com.projectb.nogo.domain.WorkerInfo;
import com.projectb.nogo.service.WorkerAccountDto;
import com.projectb.nogo.service.WorkerDto;
import com.projectb.nogo.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/worker")
@RequiredArgsConstructor
public class WorkerController {

    private WorkerService workerService;

    @GetMapping("/join")
    public String workerJoinForm() {
        return "worker/join";
    }
    @PostMapping("/join")
    public String workerJoin(@RequestBody WorkerDto dto) {

        WorkerAccountDto account = new WorkerAccountDto();
        WorkerInfo worker = new WorkerInfo(dto);

        WorkerInfo savedWorker = workerService.createWorker(worker);

        account.setWorkerInfoIdx(savedWorker.getWorkerIdx());
        account.setWorkerId(dto.getWorkerId());
        account.setWorkerPw(dto.getWorkerPw());
        account.setLoginType(dto.getLoginType());

        workerService.saveAccount(account);

        return "redirect:";
    }

}
