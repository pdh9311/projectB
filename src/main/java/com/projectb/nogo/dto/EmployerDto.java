package com.projectb.nogo.dto;

import com.projectb.nogo.constant.AuthMethod;
import com.projectb.nogo.constant.ExpirationPeriod;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @NotNull : value is not null
 * @NotEmpty : value is not null && not empty("")
 * @NotBlank : value is not null && not empty("") && not black(" ")
 */
@Getter
@Setter
@ToString
public class EmployerDto {

    @AssertTrue
    private Boolean agreeService;
    @AssertTrue
    private Boolean agreePersonalInfo;
    private Boolean agreeSms;
    private Boolean agreeEmail;

    private AuthMethod authMethod;
    // private Boolean authResult;
    // private String phone;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,15}$")
    private String id;
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[\\[\\]{}\\\\|;:'\",<.>/?`~₩!@#$%^&*()_=+-])(?=.*[0-9]).{8,16}$")
    private String pw;
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[\\[\\]{}\\\\|;:'\",<.>/?`~₩!@#$%^&*()_=+-])(?=.*[0-9]).{8,16}$")
    private String rePw;

    @NotBlank
    @Email(regexp = "^[a-zA-Z0-9._+-]+@[a-zA-Z0-9._+-]+\\.[a-zA-Z0-9_+-]+$")
    private String email;

    @NotBlank
    @Pattern(regexp = "^\\d{3}$")
    private String BusinessNumber1;
    @NotBlank
    @Pattern(regexp = "^\\d{2}$")
    private String BusinessNumber2;
    @NotBlank
    @Pattern(regexp = "^\\d{5}$")
    private String BusinessNumber3;

    private ExpirationPeriod expirationPeriod;
}
