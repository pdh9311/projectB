package com.projectb.nogo.domain;

import com.projectb.nogo.dto.EmployerJoinDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Employer {
    private String employerId;
    private String employerPw;
    private Boolean employerStatus;
    private Long employerInfoIdx;

    public Employer() {
    }

    public Employer(EmployerJoinDto employerJoinDto) {
        this.employerId = employerJoinDto.getEmployerId();
        this.employerPw = employerJoinDto.getEmployerPw();
    }

    @Builder
    public Employer(String employerId, String employerPw, Boolean employerStatus, Long employerInfoIdx) {
        this.employerId = employerId;
        this.employerPw = employerPw;
        this.employerStatus = employerStatus;
        this.employerInfoIdx = employerInfoIdx;
    }
}
