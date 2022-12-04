package com.projectb.nogo.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode
@Builder
public class JobHistoryDto {
    LocalDateTime historyTime;
    String workerName;
    Integer pay;
    String workerStatus;
    Boolean paymentStatus;
    String sido;
    String sigungu;
    String eupmyeondong;
}
