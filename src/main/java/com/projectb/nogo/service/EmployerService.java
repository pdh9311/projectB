package com.projectb.nogo.service;

import com.projectb.nogo.domain.Employer;
import com.projectb.nogo.domain.EmployerInfo;
import com.projectb.nogo.dto.JobHistoryDto;
import com.projectb.nogo.domain.WorkerInfo;
import com.projectb.nogo.dto.EmployDto;
import com.projectb.nogo.dto.EmployerLoginForm;
import com.projectb.nogo.dto.LocalCodeDto;

import java.util.List;
import java.util.Optional;

public interface EmployerService {

    // 회원 저장
    void save(EmployerInfo employerInfo, Employer employer);

    // 회원 로그인
    Optional<EmployerInfo> login(EmployerLoginForm employerLoginForm);

    // 일하려 신청한 지원자들 조회
    List<WorkerInfo> findApplicants(LocalCodeDto localCodeDto);

    // 고용 내역에 추가한다.
    Boolean addEmploy(EmployDto employDto);

    // 고용 내역을 가져온다.
    List<JobHistoryDto> getJobHistory(Long employerInfoIdx);

}
