package com.projectb.nogo.domain;

import com.projectb.nogo.dto.EmployerJoinForm;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class EmployerInfo {
    private Long employerInfoIdx;
    private String employerEmail;
    private String employerPhone;
    private String businessNumber;
    private String businessName;
    private String businessAddress;
    private String bankName;
    private String bankAccountNumber;
    private Long point;
    private LocalDateTime expirationDate;
    private Boolean agreeService;
    private Boolean agreePersonalInfo;
    private Boolean agreeSms;
    private Boolean agreeEmail;

    public EmployerInfo() {}

    public EmployerInfo(EmployerJoinForm employerJoinForm) {
        this.employerEmail = employerJoinForm.getEmployerEmail();
        this.employerPhone = employerJoinForm.getEmployerPhone();
        this.businessNumber = employerJoinForm.getBusinessNumber();
        LocalDateTime dateTime = LocalDateTime.now();
        if (employerJoinForm.getExpirationPeriod() == -1) {
            dateTime = LocalDateTime.of(9999, 1, 1, 0, 0, 0);
        } else {
            dateTime = dateTime.plusYears(employerJoinForm.getExpirationPeriod());
        }
        this.expirationDate = dateTime;
        this.agreeService = employerJoinForm.getAgreeService();
        this.agreePersonalInfo = employerJoinForm.getAgreePersonalInfo();
        this.agreeSms = employerJoinForm.getAgreeSms();
        this.agreeEmail = employerJoinForm.getAgreeEmail();
    }

}


