package com.projectb.nogo.dto;

import com.projectb.nogo.constant.AuthMethod;
import com.projectb.nogo.constant.Period;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CorporateDto {

  private Boolean agreeService;
  private Boolean agreePersonalInfo;
  private Boolean agreeSms;
  private Boolean agreeEmail;

  private AuthMethod authMethod;
  private Boolean authResult;

  private String id;
  private String password;
  private String rePassword;

  private String email;

  private String BusinessNumber1;
  private String BusinessNumber2;
  private String BusinessNumber3;

  private Period periods;
}
