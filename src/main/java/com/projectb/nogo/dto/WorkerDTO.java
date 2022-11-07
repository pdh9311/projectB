package com.projectb.nogo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projectb.nogo.domain.WorkerHistoryVO;
import com.projectb.nogo.domain.WorkerPersonalVO;
import com.projectb.nogo.domain.WorkerPhotoVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class WorkerDTO {


//  private Boolean agreeService;
//  private Boolean agreePersonalInfo;
//  private Boolean agreeSms;
//  private Boolean agreeEmail;
//  private String radioChked;
//
//  private String id;
//  private String password;
//  private String rePassword;
//
//  private String email;
//  private String phone;
//  private String name;
//  private String adr;
//  private String adrDetail;
  private WorkerPersonalVO personal;
  private List<WorkerHistoryVO> historyList;
  private List<WorkerPhotoVO> photoList;

  /*private String historyStartDate;
  private String historyEndDate;
  private String historyContent;*/
}
