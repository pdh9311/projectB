package com.projectb.nogo.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class LocalCode {

    private String sidoCode;
    private String sidoName;
    private String sigunguCode;
    private String sigunguName;
    private String eupmyeondongCode;
    private String eupmyeondongName;

    @Builder
    public LocalCode(String sidoCode, String sidoName, String sigunguCode, String sigunguName, String eupmyeondongCode, String eupmyeondongName) {
        this.sidoCode = sidoCode;
        this.sidoName = sidoName;
        this.sigunguCode = sigunguCode;
        this.sigunguName = sigunguName;
        this.eupmyeondongCode = eupmyeondongCode;
        this.eupmyeondongName = eupmyeondongName;
    }
}
