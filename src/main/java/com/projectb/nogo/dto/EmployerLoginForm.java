package com.projectb.nogo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployerLoginForm {
    private String employerId;
    private String employerPw;
}
