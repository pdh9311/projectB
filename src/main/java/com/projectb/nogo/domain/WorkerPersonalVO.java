package com.projectb.nogo.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class WorkerPersonalVO {
    private Boolean agreeService;
    private Boolean agreePersonalInfo;
    private Boolean agreeSms;
    private Boolean agreeEmail;
    private int period;
    private String id;
    private String password;
    private String email;
    private String phone;
    private String name;
    private String adr;
    private String adrDetail;

//    public WorkerPersonalVO (WorkerDTO2 dto){
//        agreeService = dto.getAgreeService();
//        agreePersonalInfo = dto.getAgreePersonalInfo();
//        agreeSms = dto.getAgreeSms();
//        agreeEmail = dto.getAgreeEmail();
//        period = dto.getRadioChked();
//        id = dto.getId();
//        password = dto.getPassword();
//        rePassword = dto.getRePassword();
//        email = dto.getEmail();
//        phone = dto.getPhone();
//        name = dto.getName();
//        adr = dto.getAdr();
//        adrDetail = dto.getAdrDetail();
//    }
}
