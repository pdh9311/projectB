package com.projectb.nogo.domain;

import com.projectb.nogo.constant.ExpirationPeriod;
import com.projectb.nogo.dto.EmployerDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode
public class Employer {
    private Long idx;
    private String employerId;
    private String employerPw;
    private String email;
    //  private String phone;
    private String businessNumber;
    private LocalDateTime expirationPeriod;
    private Boolean agreeService;
    private Boolean agreePersonalInfo;
    private Boolean agreeSms;
    private Boolean agreeEmail;

    public Employer() {}

    public Employer(EmployerDto employerDto) {
        this.employerId = employerDto.getId();
        this.employerPw = employerDto.getPw();
        this.email = employerDto.getEmail();
        this.businessNumber = employerDto.getBusinessNumber1() + "-" + employerDto.getBusinessNumber2() + "-" + employerDto.getBusinessNumber3();
        this.expirationPeriod = getLocalDateTime(employerDto);
        this.agreeService = employerDto.getAgreeService();
        this.agreePersonalInfo = employerDto.getAgreePersonalInfo();
        this.agreeSms = employerDto.getAgreeSms();
        this.agreeEmail = employerDto.getAgreeEmail();
    }
    private LocalDateTime getLocalDateTime(EmployerDto employerDto) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dateTime = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), now.getHour(), now.getMinute(), now.getSecond());

        if (employerDto.getExpirationPeriod() == ExpirationPeriod.ONE_YEAR) {
            dateTime = dateTime.plusYears(ExpirationPeriod.ONE_YEAR.getPeriod());
        } else if (employerDto.getExpirationPeriod() == ExpirationPeriod.THREE_YEAR) {
            dateTime = dateTime.plusYears(ExpirationPeriod.THREE_YEAR.getPeriod());
        } else {
            dateTime = LocalDateTime.of(9999, 1, 1, 0, 0);
        }
        return dateTime;
    }

}
