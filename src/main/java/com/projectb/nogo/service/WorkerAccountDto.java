package com.projectb.nogo.service;

import com.projectb.nogo.domain.Worker;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WorkerAccountDto {
    private int loginType;
    private String workerId;
    private String workerPw;
    private Integer workerInfoIdx;

}
