package com.projectb.nogo.domain;

import com.projectb.nogo.dto.WorkerJoinForm;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Worker {

    private Integer loginType;
    private String workerId;
    private String workerPw;
    private Long workerInfoIdx;

    public Worker(WorkerJoinForm workerJoinForm) {
        this.workerId = workerJoinForm.getWorkerId();
        this.workerPw = workerJoinForm.getWorkerPw();
    }

    public Worker() {
    }

    @Builder
    public Worker(Integer loginType, String workerId, String workerPw, Long workerInfoIdx) {
        this.loginType = loginType;
        this.workerId = workerId;
        this.workerPw = workerPw;
        this.workerInfoIdx = workerInfoIdx;
    }
}
