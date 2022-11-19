package com.projectb.nogo.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WorkerDto {
    private int loginType;
    private String workerId;
    private String workerPw;
    private String workerEmail;
    private String workerName;
    private Boolean workerGender;
    private String workerPhone;
    private String workerBirth;
    private String workerCareer;
    private String workerPhoto1;
    private String workerPhoto2;
    private String bankName;
    private String bankAccountNumber;
    private int point;
    private Boolean agreeService;
    private Boolean agreePersonalInfo;
    private Boolean agreeSms;
    private Boolean agreeEmail;
    private String expirationDate;
}
