package com.projectb.nogo.repository;


import com.projectb.nogo.domain.Employer;
import com.projectb.nogo.dto.EmployerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Slf4j
@Repository
public class JoinRepository {

  private final NamedParameterJdbcTemplate template;

  public JoinRepository(DataSource dataSource) {
    this.template = new NamedParameterJdbcTemplate(dataSource);
  }

  public Employer save(Employer employer) {
    String sql = "INSERT INTO employer(id, pw, email, business_number, expiration_period, agree_service, agree_personal_info, agree_sms, agree_email) " +
        "VALUES (:id, :pw, :email, :businessNumber, :expirationPeriod, :agreeService, :agreePersonalInfo, :agreeSms, :agreeEmail)";

    KeyHolder keyHolder = new GeneratedKeyHolder();

    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("id", employer.getId())
        .addValue("Pw", employer.getPw())
        .addValue("email", employer.getEmail())
//        .addValue("phone", employer.getPhone())
        .addValue("businessNumber", employer.getBusinessNumber())
        .addValue("expirationPeriod", employer.getExpirationPeriod())
        .addValue("agreeService", employer.getAgreeService())
        .addValue("agreePersonalInfo", employer.getAgreePersonalInfo())
        .addValue("agreeSms", employer.getAgreeSms())
        .addValue("agreeEmail", employer.getAgreeEmail());

    SqlParameterSource params = new BeanPropertySqlParameterSource(employer);

    template.update(sql, params, keyHolder);
    long key = keyHolder.getKey().longValue();
    employer.setI(key);
    return employer;
  }
}
