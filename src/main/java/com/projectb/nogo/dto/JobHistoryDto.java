package com.projectb.nogo.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode
public class JobHistoryDto {

    LocalDateTime historyTime;
    String workerName;
    Integer pay;
    String workerStatus;
    Boolean paymentStatus;

    @Builder
    public JobHistoryDto(LocalDateTime historyTime, String workerName, Integer pay, String workerStatus, Boolean paymentStatus) {
        this.historyTime = historyTime;
        this.workerName = workerName;
        this.pay = pay;
        this.workerStatus = workerStatus;
        this.paymentStatus = paymentStatus;
    }
}
