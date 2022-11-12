package com.projectb.nogo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Kakao {
    private static final String AUTH_HOST = "https://kauth.kakao.com";
    private static final String API_HOST = "https://kapi.kakao.com";
    private static final String AUTHORIZE = "/oauth/authorize";
    private static final String TOKEN = "/oauth/token";
    private static final String PROFILE = "/v2/user/me";
    private static final String CLIENT_ID = "5a6acee80360ee024e369dcc8c9b2392";
    private static final String REDIRECT_URI = "http://localhost:9090/login/auth/kakao";

    public static String createAuthRequestUrl() {
        return AUTH_HOST + AUTHORIZE +
            "?client_id=" + CLIENT_ID +
            "&redirect_uri=" + REDIRECT_URI +
            "&response_type=code" ;
    }

    public static String createTokenRequestUrl(String code) {
        return AUTH_HOST + TOKEN +
            "?grant_type=authorization_code" +
            "&client_id=" + CLIENT_ID +
            "&redirect_uri=" + REDIRECT_URI +
            "&code=" + code;
    }

    public static String createKakaoUserProfileUrl() {
        return API_HOST + PROFILE;
    }



}
