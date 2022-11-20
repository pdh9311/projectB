package com.projectb.nogo.service;

import com.projectb.nogo.domain.Employer;
import com.projectb.nogo.domain.EmployerInfo;
import com.projectb.nogo.dto.EmployerLoginForm;

import java.util.Optional;

public interface EmployerService {

    // 회원 저장
    void save(EmployerInfo employerInfo, Employer employer);

    // 회원 로그인
    Optional<EmployerInfo> login(EmployerLoginForm employerLoginForm);

    // 일하려 신청한 지원자들 조회
//    List<Worker> findApplicants();

}
