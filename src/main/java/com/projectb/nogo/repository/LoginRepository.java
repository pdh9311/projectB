package com.projectb.nogo.repository;

import com.projectb.nogo.domain.Employer;
import com.projectb.nogo.dto.LoginEmployerDto;

import java.util.Optional;

public interface LoginRepository {

    // 고용자 아이디 비밀번호가 일치하는 데이터가 있는지 조회
    Optional<Employer> findByIdAndPw(LoginEmployerDto loginEmployerDto);


}
