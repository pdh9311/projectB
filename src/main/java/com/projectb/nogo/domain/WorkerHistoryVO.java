package com.projectb.nogo.domain;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Getter
@ToString
public class WorkerHistoryVO {
    @NotEmpty
    private String historyStartDate;
    @NotEmpty
    private String historyEndDate;
    @NotEmpty
    private String historyContent;

//  public WorkerHistoryVO(WorkerDTO2 dto){
//     historyStartDate = dto.getHistoryStartDate();
//     historyEndDate = dto.getHistoryEndDate();
//     historyContent = dto.getHistoryContent();
//  }
}
