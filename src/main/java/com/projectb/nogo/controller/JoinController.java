package com.projectb.nogo.controller;

import com.projectb.nogo.domain.WorkerHistoryVO;
import com.projectb.nogo.domain.WorkerPersonalVO;
import com.projectb.nogo.domain.WorkerPhotoVO;
import com.projectb.nogo.dto.EmployerDto;
import com.projectb.nogo.dto.WorkerDTO;
import com.projectb.nogo.service.JoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    @PostMapping("/employer")
    public String CompleteJoinEmployer(EmployerDto employerDto) {
        log.info("corporateDto={}", employerDto);
        joinService.save(employerDto);
        return "redirect:/";
    }

    @GetMapping("/worker")
    public String joinWorkerPage() {
        return "join/worker";
    }

    @PostMapping(value = "/worker")
    public String CompleteJoinWorker(@RequestPart("personal") WorkerDTO workerDto , @RequestPart(value = "file" , required = false) List<MultipartFile> file) {

        WorkerPersonalVO personal = workerDto.getPersonal();
        List<WorkerHistoryVO> historyList = workerDto.getHistoryList();
        log.info("historyList : {}", historyList);
        log.info("personal : {}", personal);
        log.info("file : {}", file.get(0).getOriginalFilename());
//        log.info("file : {}", file.get(1).getOriginalFilename());
//        log.info("file : {}", file.get(1).getContentType());
//        log.info("file : {}", file.get(1).getSize());
        //log.info("photoList : {}", photoList);

        joinService.workerPersonal(personal);
        //joinService.workerHistorys(historyList);
        //joinService.workerPhotos(photoList);
        return "redirect:/";
    }
}

