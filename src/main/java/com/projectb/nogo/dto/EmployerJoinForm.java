package com.projectb.nogo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 정규표현식으로 값이 제대로 들어왔는지 확인할 필요가 있음
 */
@Setter
@Getter
@ToString
public class EmployerJoinForm {
    @NotBlank
    private String employerId;
    @NotBlank
    private String employerPw;
    @NotBlank
    private String employerPhone;
    @NotBlank
    private String employerEmail;
    @NotBlank
    private String businessNumber;
    @NotNull
    private Boolean agreeService;
    @NotNull
    private Boolean agreePersonalInfo;
    private Boolean agreeSms;
    private Boolean agreeEmail;
    @NotNull
    private Integer expirationPeriod;
}
