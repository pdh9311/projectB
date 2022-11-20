package com.projectb.nogo.service;

import com.projectb.nogo.domain.Employer;
import com.projectb.nogo.domain.EmployerInfo;
import com.projectb.nogo.dto.EmployerLoginForm;
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
        employerRepository.saveIdPw(employer, idx);
    }

    @Override
    public Optional<EmployerInfo> login(EmployerLoginForm employerLoginForm) {
        Employer employer = employerRepository.findByEmployerIdPw(employerLoginForm).get();
        return employerRepository.findByEmployerInfoIdx(employer.getEmployerInfoIdx());
    }


}
