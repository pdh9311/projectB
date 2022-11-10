package com.projectb.nogo.service;

import com.projectb.nogo.constant.ExpirationPeriod;
import com.projectb.nogo.domain.Employer;
import com.projectb.nogo.dto.EmployerDto;
import com.projectb.nogo.repository.JoinRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class JoinServiceTest {

    @Autowired
    JoinService joinService;

    EmployerDto employerDto;

    @BeforeEach
    void beforeEach() {
        employerDto = new EmployerDto();
        employerDto.setAgreeService(true);
        employerDto.setAgreePersonalInfo(true);
        employerDto.setAgreeSms(true);
        employerDto.setAgreeEmail(true);
        employerDto.setId("abc1234");
        employerDto.setPw("qwe123!@#");
        employerDto.setRePw("qwe123!@#");
        employerDto.setEmail("abc@gmail.com");
        employerDto.setBusinessNumber1("123");
        employerDto.setBusinessNumber2("12");
        employerDto.setBusinessNumber3("12345");
    }

    @Test
    void saveExpirationPeriodOneYear() {
        employerDto.setExpirationPeriod(ExpirationPeriod.ONE_YEAR);
        Employer savedEmployer = joinService.save(employerDto);
        assertThat(savedEmployer.getExpirationPeriod().getYear())
            .isEqualTo(LocalDateTime.now().getYear() + 1);
    }

    @Test
    void saveExpirationPeriodThreeYear() {
        employerDto.setExpirationPeriod(ExpirationPeriod.THREE_YEAR);
        Employer savedEmployer = joinService.save(employerDto);
        assertThat(savedEmployer.getExpirationPeriod().getYear())
            .isEqualTo(LocalDateTime.now().getYear() + 3);
    }

    @Test
    void saveExpirationPeriodUntilWithdrawal() {
        employerDto.setExpirationPeriod(ExpirationPeriod.UNTIL_WITHDRAWAL);
        Employer savedEmployer = joinService.save(employerDto);
        assertThat(savedEmployer.getExpirationPeriod().getYear())
            .isEqualTo(9999);
    }

}