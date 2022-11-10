package com.projectb.nogo.service;

import com.projectb.nogo.constant.ExpirationPeriod;
import com.projectb.nogo.domain.Employer;
import com.projectb.nogo.dto.EmployerDto;
import com.projectb.nogo.repository.JoinRepository;
import com.projectb.nogo.security.lea.LeaTool;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class JoinService {

    private final JoinRepository joinRepository;

    public Employer save(EmployerDto employerDto) {
        Employer employer = new Employer();
        employer.setId(employerDto.getId());

//        LeaTool leaTool = new LeaTool();
//        try {
//            String encrypt = leaTool.encrypt(employerDto.getPw());
//            log.info("encrypt = {}", encrypt);
//            employer.setPw(encrypt);
//        } catch (UnsupportedEncodingException e) {
//            throw new RuntimeException(e);
//        }
        employer.setPw(employerDto.getPw());
        employer.setEmail(employerDto.getEmail());
        employer.setBusinessNumber(employerDto.getBusinessNumber1() + "-" + employerDto.getBusinessNumber2() + "-" + employerDto.getBusinessNumber3());

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dateTime = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), now.getHour(), now.getMinute(), now.getSecond());

        if (employerDto.getExpirationPeriod() == ExpirationPeriod.ONE_YEAR) {
            dateTime = dateTime.plusYears(ExpirationPeriod.ONE_YEAR.getPeriod());
        } else if (employerDto.getExpirationPeriod() == ExpirationPeriod.THREE_YEAR) {
            dateTime = dateTime.plusYears(ExpirationPeriod.THREE_YEAR.getPeriod());
        } else {
            dateTime = LocalDateTime.of(9999, 1, 1, 0, 0);
        }
        log.info("dataTime = {}", dateTime);
        employer.setExpirationPeriod(dateTime);
        employer.setAgreeService(employerDto.getAgreeService());
        employer.setAgreePersonalInfo(employerDto.getAgreePersonalInfo());
        employer.setAgreeSms(employerDto.getAgreeSms());
        employer.setAgreeEmail(employerDto.getAgreeEmail());

        return joinRepository.save(employer);
    }
}
