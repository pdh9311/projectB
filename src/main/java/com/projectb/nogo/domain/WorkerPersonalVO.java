package com.projectb.nogo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class WorkerPersonalVO {

  private Boolean agreeService;
  private Boolean agreePersonalInfo;
  private Boolean agreeSms;
  private Boolean agreeEmail;
  private int period;

  private String id;
  private String password;
  private String rePassword;

  private String email;
  private String phone;
  private String name;
  private String adr;
  private String adrDetail;
}
