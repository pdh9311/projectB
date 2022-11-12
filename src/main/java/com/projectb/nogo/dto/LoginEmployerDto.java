package com.projectb.nogo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginEmployerDto {
    @NotBlank
    private String employerId;

    @NotBlank
    private String employerPw;
}
