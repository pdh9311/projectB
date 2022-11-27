package com.projectb.nogo.service;

import com.projectb.nogo.domain.Employer;
import com.projectb.nogo.domain.EmployerInfo;
import com.projectb.nogo.dto.JobHistoryDto;
import com.projectb.nogo.domain.WorkerInfo;
import com.projectb.nogo.dto.EmployDto;
import com.projectb.nogo.dto.EmployerLoginForm;
import com.projectb.nogo.dto.LocalCodeDto;
import com.projectb.nogo.repository.EmployerRepository;
import com.projectb.nogo.repository.LocalCodeRepository;
import com.projectb.nogo.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployerServiceImpl implements EmployerService {

    private final EmployerRepository employerRepository;
    private final LocalCodeRepository localCodeRepository;
    private final WorkerRepository workerRepository;

    @Transactional
    @Override
    public void save(EmployerInfo employerInfo, Employer employer) {
        Long idx = employerRepository.saveInfo(employerInfo);
        employerRepository.saveIdPw(employer, idx);
    }

    @Transactional
    @Override
    public Optional<EmployerInfo> login(EmployerLoginForm employerLoginForm) {
        Employer employer = employerRepository.findByEmployerIdPw(employerLoginForm).get();
        return employerRepository.findByEmployerInfoIdx(employer.getEmployerInfoIdx());
    }

    @Transactional
    @Override
    public List<WorkerInfo> findApplicants(LocalCodeDto localCodeDto) {
        List<Long> localCodeIdxes = localCodeRepository.getLocalCodeIdxes(localCodeDto);
        List<WorkerInfo> applicants = employerRepository.findApplicants(localCodeIdxes);
        return applicants;
    }

    @Transactional
    @Override
    public Boolean addEmploy(EmployDto employDto) {
        // 근로자가 지원한 지역 조회
        Long localCodeIdx = localCodeRepository.getLocalCodeIdx(employDto.getSidoCode(), employDto.getSigunguCode(), employDto.getEupmyeondongCode());
        // 근로자의 지원상태를 변경
        workerRepository.modifyApplyStatus(employDto.getWorkerInfoIdx(), localCodeIdx);
        // 고용내역에 추가
        return employerRepository.addEmploy(employDto);
    }

    @Override
    public List<JobHistoryDto> getJobHistory(Long employerInfoIdx) {
        List<JobHistoryDto> jobHistories = employerRepository.getJobHistory(employerInfoIdx).get();
        return jobHistories;
    }
}
