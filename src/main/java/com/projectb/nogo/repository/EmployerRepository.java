package com.projectb.nogo.repository;

import com.projectb.nogo.domain.Employer;
import com.projectb.nogo.domain.EmployerInfo;
import com.projectb.nogo.dto.EmployerLoginForm;

import java.util.Optional;

public interface EmployerRepository {

    // 회원 정보 저장
    Long saveInfo(EmployerInfo employerInfo);

    // 회원 아이디, 비밀번호 저장
    void saveIdPw(Employer employer, Long employerInfoIdx);

    // 아이디 와 비밀번호로 회원 찾기
    Optional<Employer> findByEmployerIdPw(EmployerLoginForm employerLoginForm);

    // 외래키값으로 회원 정보 가져오기
    Optional<EmployerInfo> findByEmployerInfoIdx(Long employerInfoIdx);


}
