package com.projectb.nogo.domain;

import com.projectb.nogo.dto.EmployerJoinDto;
import lombok.Builder;
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

    public EmployerInfo(EmployerJoinDto employerJoinDto) {
        this.employerEmail = employerJoinDto.getEmployerEmail();
        this.employerPhone = employerJoinDto.getEmployerPhone();
        this.businessNumber = employerJoinDto.getBusinessNumber();
        LocalDateTime dateTime = LocalDateTime.now();
        if (employerJoinDto.getExpirationPeriod() == -1) {
            dateTime = LocalDateTime.of(9999, 1, 1, 0, 0, 0);
        } else {
            dateTime = dateTime.plusYears(employerJoinDto.getExpirationPeriod());
        }
        this.expirationDate = dateTime;
        this.agreeService = employerJoinDto.getAgreeService();
        this.agreePersonalInfo = employerJoinDto.getAgreePersonalInfo();
        this.agreeSms = employerJoinDto.getAgreeSms();
        this.agreeEmail = employerJoinDto.getAgreeEmail();
    }

}


