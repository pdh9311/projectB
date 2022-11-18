package com.projectb.nogo.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
public class WorkerJoinDto {

    @NotBlank
    private String workerId;

    @NotBlank
    private String workerPw;

    @NotBlank
    private String workerName;

    @NotBlank
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String workerBirth;

    @NotBlank
    private String workerGender;

    @NotBlank
    private String workerEmail;

    @NotBlank
    private String workerPhone;

    @NotNull
    private Boolean agreeService;

    @NotNull
    private Boolean agreePersonalInfo;

    private Boolean agreeSms;

    private Boolean agreeEmail;

    @NotNull
    private Integer expirationPeriod;
}
