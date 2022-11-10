package com.projectb.nogo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Employer {
    private Long i;
    private String id;
    private String pw;
    private String email;
    //  private String phone;
    private String businessNumber;
    private LocalDateTime expirationPeriod;
    private Boolean agreeService;
    private Boolean agreePersonalInfo;
    private Boolean agreeSms;
    private Boolean agreeEmail;
}
