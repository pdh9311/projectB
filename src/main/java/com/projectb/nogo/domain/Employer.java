package com.projectb.nogo.domain;

import com.projectb.nogo.dto.EmployerJoinForm;
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

    public Employer(EmployerJoinForm employerJoinForm) {
        this.employerId = employerJoinForm.getEmployerId();
        this.employerPw = employerJoinForm.getEmployerPw();
    }

    @Builder
    public Employer(String employerId, String employerPw, Boolean employerStatus, Long employerInfoIdx) {
        this.employerId = employerId;
        this.employerPw = employerPw;
        this.employerStatus = employerStatus;
        this.employerInfoIdx = employerInfoIdx;
    }
}
