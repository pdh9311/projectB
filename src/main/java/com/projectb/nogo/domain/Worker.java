package com.projectb.nogo.domain;


import com.projectb.nogo.service.WorkerAccountDto;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Worker {
    private String loginType;
    private Integer workerInfoIdx;
    private Boolean workerStatus;
    private String workerId;
    private String workerPw;


    public Worker(WorkerAccountDto dto) {
        this.loginType = dto.getLoginType();
        this.workerId = dto.getWorkerId();
        this.workerPw = dto.getWorkerPw();
        this.workerInfoIdx = dto.getWorkerInfoIdx();
    }
}


