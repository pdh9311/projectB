package com.projectb.nogo.domain;

/*
    {
        "id":2521025278,
        "connected_at":"2022-11-11T07:38:45Z",
        "kakao_account":{
            "has_email":true,
            "email_needs_agreement":false,
            "is_email_valid":true,
            "is_email_verified":true,
            "email":"padohy@gmail.com"
        }
    }
*/

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class KakaoProfile {
    private Long id;
    @JsonProperty("connected_at")
    private LocalDateTime connectedAt;
    @JsonProperty("kakao_account")
    private KakaoAccount kakaoAccount;

    @Getter
    @Setter
    static class KakaoAccount {
        @JsonProperty("has_email")
        private Boolean hasEmail;
        @JsonProperty("email_needs_agreement")
        private Boolean emailNeedsAgreement;
        @JsonProperty("is_email_valid")
        private Boolean isEmailValid;
        @JsonProperty("is_email_verified")
        private Boolean isEmailVerified;
        private String email;
    }

}
