package com.projectb.nogo.repository;

import com.projectb.nogo.constant.ExpirationPeriod;
import com.projectb.nogo.domain.Employer;
import com.projectb.nogo.dto.EmployerDto;
import com.projectb.nogo.service.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@SpringBootTest
class JoinRepositoryImplTest {

    @Autowired
    JoinServiceImpl joinServiceImpl;

    @Autowired
    JoinRepositoryImpl joinRepositoryImpl;

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
        Employer savedEmployer = joinServiceImpl.save(new Employer(employerDto));
        Optional<Employer> findEmployer = joinRepositoryImpl.findById(savedEmployer.getIdx());
        assertThat(savedEmployer).usingRecursiveComparison()
            .isEqualTo(findEmployer.get());
    }
}