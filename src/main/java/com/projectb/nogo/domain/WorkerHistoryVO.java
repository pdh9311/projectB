package com.projectb.nogo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class WorkerHistoryVO {

  private String historyStartDate;
  private String historyEndDate;
  private String historyContent;
}
