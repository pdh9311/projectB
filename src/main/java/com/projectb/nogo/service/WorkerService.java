package com.projectb.nogo.service;

import com.projectb.nogo.domain.Worker;
import com.projectb.nogo.domain.WorkerInfo;
import com.projectb.nogo.dto.LocalCodeDto;
import com.projectb.nogo.dto.WorkerLoginForm;

import java.util.Optional;

public interface WorkerService {
    // 회원 저장
    void save(WorkerInfo workerInfo, Worker worker);

    // 회원 로그인
    Optional<WorkerInfo> login(WorkerLoginForm workerLoginForm);

    // 일자리 지원 신청
    Boolean applyJob(LocalCodeDto localCodeDto);

}
