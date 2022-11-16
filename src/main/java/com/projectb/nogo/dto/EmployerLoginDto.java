package com.projectb.nogo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployerLoginDto {
    private String employerId;
    private String employerPw;
}
