package com.projectb.nogo.repository;

import com.projectb.nogo.domain.Worker;
import com.projectb.nogo.domain.WorkerInfo;
import com.projectb.nogo.dto.WorkerLoginForm;

import java.util.Optional;

public interface WorkerRepository {
    // 회원 정보 저장
    Long saveInfo(WorkerInfo workerInfo);

    // 회원 아이디, 비밀번호 저장
    void saveIdPw(Worker worker, Long workerInfoIdx);

    // 아이디와 비밀번호로 회원 정보의 키값 찾기
    Optional<Worker> findByWorkerIdPw(WorkerLoginForm workerLoginForm);

    // 키값으로 회원 정보 가져오기
    Optional<WorkerInfo> findByWorkerInfoIdx(Long workerInfoIdx);

}
