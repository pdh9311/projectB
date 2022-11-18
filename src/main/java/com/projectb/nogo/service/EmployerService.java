package com.projectb.nogo.service;

import com.projectb.nogo.domain.Employer;
import com.projectb.nogo.domain.EmployerInfo;
import com.projectb.nogo.dto.EmployerLoginDto;

import java.util.Map;
import java.util.Optional;

public interface EmployerService {

    // 회원 저장
    void save(EmployerInfo employerInfo, Employer employer);

    // 회원 로그인
    Optional<EmployerInfo> login(EmployerLoginDto employerLoginDto);

    // 시도 정보 리스트로 가져오기
    Map<String, String> findSidoList();

    // 시군구 정보 리스트로 가져오기
    Map<String, String> findSigunguList(String sidoCode);

    // 읍면동 정보 리스트로 가져오기
    Map<String, String> findEupmyeondongList(String sidoCode, String sigunguCode);

}
