package com.projectb.nogo.domain;

import com.projectb.nogo.dto.WorkerJoinForm;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class WorkerInfo {

    private Long workerInfoIdx;
    private String workerName;
    private String workerEmail;
    private String workerGender;
    private String workerPhone;
    private LocalDate workerBirth;
    private String workerCareer;
    private String workerPhoto1;
    private String workerPhoto2;
    private String bankName;
    private String bankAccountNumber;
    private Long point;
    private Boolean agreeService;
    private Boolean agreePersonalInfo;
    private Boolean agreeSms;
    private Boolean agreeEmail;

    public WorkerInfo(WorkerJoinForm workerJoinForm) {
        this.workerName = workerJoinForm.getWorkerName();
        this.workerEmail = workerJoinForm.getWorkerEmail();
        this.workerGender = workerJoinForm.getWorkerGender();
        this.workerPhone = workerJoinForm.getWorkerPhone();
        this.workerBirth = workerJoinForm.getWorkerBirth();
        this.agreeService = workerJoinForm.getAgreeService();
        this.agreePersonalInfo = workerJoinForm.getAgreePersonalInfo();
        this.agreeEmail = workerJoinForm.getAgreeEmail();
        this.agreeSms = workerJoinForm.getAgreeSms();
    }

    @Builder
    public WorkerInfo(Long workerInfoIdx, String workerName, String workerEmail, String workerGender, String workerPhone, LocalDate workerBirth, Boolean agreeService, Boolean agreePersonalInfo, Boolean agreeSms, Boolean agreeEmail) {
        this.workerInfoIdx = workerInfoIdx;
        this.workerName = workerName;
        this.workerEmail = workerEmail;
        this.workerGender = workerGender;
        this.workerPhone = workerPhone;
        this.workerBirth = workerBirth;
        this.agreeService = agreeService;
        this.agreePersonalInfo = agreePersonalInfo;
        this.agreeSms = agreeSms;
        this.agreeEmail = agreeEmail;
    }
}
