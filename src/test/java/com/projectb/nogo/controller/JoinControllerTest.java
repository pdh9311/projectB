package com.projectb.nogo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectb.nogo.constant.ExpirationPeriod;
import com.projectb.nogo.dto.EmployerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

/**
 * @ExtendWith(SpringExtension.class)
 * - 확장을 선언적으로 등록해 주는 역할을 한다. ExtendWith 뒤에 인자로 확장할 Extension을 추가하여 사용 할 수 있다.
 * - Spring을 사용할 경우 @ExtendWith(SpringExtension.class)와 같이 사용한다.
 *
 * @WebMvcTest - JPA 기능은 동작하지 않는다.
 * - 여러 스프링 테스트 어노테이션 중, Web(Spring MVC)에만 집중할 수 있는 어노테이션
 * - @Controller, @ControllerAdvice 사용 가능
 * - 단, @Service, @Repository등은 사용할 수 없다.
 */
//@ExtendWith(SpringExtension.class)
@WebMvcTest(JoinController.class)
class JoinControllerTest {

    /**
     * 웹 API 테스트할 때 사용
     * 스프링 MVC 테스트의 시작점
     * HTTP GET,POST 등에 대해 API 테스트 가능
     */
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void completeJoinEmployer() throws Exception {
        EmployerDto employerDto = new EmployerDto();
        employerDto.setAgreeService(true);
        employerDto.setAgreePersonalInfo(true);
        employerDto.setAgreeSms(true);
        employerDto.setAgreeEmail(true);
        employerDto.setId("abc1234");
        employerDto.setPw("qwe123!@#");
        employerDto.setRePw("qwe123!@#");
        employerDto.setEmail("abc@gmail.com");
        employerDto.setBusinessNumber1("123");
        employerDto.setBusinessNumber1("12");
        employerDto.setBusinessNumber1("12345");
        employerDto.setExpirationPeriod(ExpirationPeriod.UNTIL_WITHDRAWAL);
        String content = objectMapper.writeValueAsString(employerDto);

        mockMvc.perform(post("/join/employer")
                .content(content)
                .accept(MediaType.APPLICATION_FORM_URLENCODED_VALUE))
//            .andExpect(status().isOk())
            .andExpect(redirectedUrl("/"))
            .andDo(print());
    }

}