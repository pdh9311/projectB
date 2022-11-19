package com.projectb.nogo.domain;

import com.projectb.nogo.service.WorkerDto;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Getter
@ToString
public class WorkerInfo {

    private Integer  ;
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
    private Date expirationDate;

    public WorkerInfo() {
    }

    public WorkerInfo(WorkerDto dto) {
        this.workerIdx = null;
        this.workerEmail = dto.getWorkerEmail();
        this.workerName = dto.getWorkerName();
        this.workerGender = dto.getWorkerGender();
        this.workerPhone = dto.getWorkerPhone();
        this.workerBirth = dto.getWorkerBirth();
        this.workerCareer = dto.getWorkerCareer();
        this.workerPhoto1 = dto.getWorkerPhoto1();
        this.workerPhoto2 = dto.getWorkerPhoto2();
        this.bankName = dto.getBankName();
        this.bankAccountNumber = dto.getBankAccountNumber();
        this.point = dto.getPoint();
        this.agreeService = dto.getWorkerGender();
        this.agreePersonalInfo = dto.getAgreePersonalInfo();
        this.agreeSms = dto.getAgreeSms();
        this.agreeEmail = dto.getAgreeEmail();
        this.expirationDate = getExpirationDate(dto.getExpirationDate());
    }


    private Date getExpirationDate(String year) {
        LocalDate now = LocalDate.now();
        now.plusYears(Long.parseLong(year));
        return java.sql.Date.valueOf(now);
    }
}


