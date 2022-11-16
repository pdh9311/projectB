package com.projectb.nogo.service;

import com.projectb.nogo.domain.Employer;
import com.projectb.nogo.domain.EmployerInfo;
import com.projectb.nogo.dto.EmployerLoginDto;
import com.projectb.nogo.repository.EmployerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployerServiceImpl implements EmployerService {

    private final EmployerRepository employerRepository;

    @Transactional
    @Override
    public void save(EmployerInfo employerInfo, Employer employer) {
        Long idx = employerRepository.saveInfo(employerInfo);
        log.info("key = {}", idx);
        employerRepository.saveIdPw(employer, idx);
    }

    @Override
    public Optional<EmployerInfo> login(EmployerLoginDto employerLoginDto) {

        Employer employer = employerRepository.findByEmployerIdPw(employerLoginDto).get();
        log.info("employerInfoIdx = {}", employer.getEmployerInfoIdx());
        return employerRepository.findByEmployerInfoIdx(employer.getEmployerInfoIdx());
    }
}
