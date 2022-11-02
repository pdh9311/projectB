package com.projectb.nogo.repository;


import com.projectb.nogo.dto.EmployerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Slf4j
@Repository
public class JoinRepository {

  private final NamedParameterJdbcTemplate template;

  public JoinRepository(DataSource dataSource) {
    this.template = new NamedParameterJdbcTemplate(dataSource);
  }

  public void save(EmployerDto employerDto) {
    String sql = "INSERT INTO corporate(id, password, email, agree_service, agree_personal_info, agree_sms, agree_email, auth_method, auth_result, business_number, periods) " +
        "VALUES (:id, :password, :email, :agreeService, :agreePersonalInfo, :agreeSms, :agreeEmail, :authMethod, :authResult, :businessNumber, :periods)";

    MapSqlParameterSource param = new MapSqlParameterSource()
        .addValue("id", employerDto.getId())
        .addValue("password", employerDto.getPassword())
        .addValue("email", employerDto.getEmail())
        .addValue("agreeService", employerDto.getAgreeService())
        .addValue("agreePersonalInfo", employerDto.getAgreePersonalInfo())
        .addValue("agreeSms", employerDto.getAgreeSms())
        .addValue("agreeEmail", employerDto.getAgreeEmail())
        .addValue("authMethod", employerDto.getAuthMethod().getMethod())
        .addValue("authResult", employerDto.getAuthResult())
        .addValue("businessNumber", employerDto.getBusinessNumber1() + "-" + employerDto.getBusinessNumber2() + "-" + employerDto.getBusinessNumber3())
        .addValue("periods", employerDto.getPeriods().getPeriod());
    template.update(sql, param);

  }
}
