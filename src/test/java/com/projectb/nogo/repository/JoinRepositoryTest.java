package com.projectb.nogo.repository;

import com.projectb.nogo.constant.ExpirationPeriod;
import com.projectb.nogo.domain.Employer;
import com.projectb.nogo.dto.EmployerDto;
import com.projectb.nogo.service.JoinService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class JoinRepositoryTest {

    @Autowired
    JoinService joinService;

    @Autowired
    JoinRepository joinRepository;

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
        employerDto.setExpirationPeriod(ExpirationPeriod.ONE_YEAR);
    }

    @Test
    void findById() {
        Employer savedEmployer = joinService.save(employerDto);
        Optional<Employer> findEmployer = joinRepository.findById(savedEmployer.getI());
        assertThat(savedEmployer).usingRecursiveComparison()
            .isEqualTo(findEmployer.get());
    }
}