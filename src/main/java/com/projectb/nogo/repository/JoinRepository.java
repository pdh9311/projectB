package com.projectb.nogo.repository;


import com.projectb.nogo.domain.Employer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.ZoneId;
import java.util.Map;
import java.util.Optional;

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

    public Optional<Employer> findById(Long i) {
//        String sql = "SELECT (i, id, pw, email, business_number, expiration_period, agree_service, agree_personal_info, agree_sms, agree_email) FROM employer WHERE i = :i";
        String sql = "SELECT * FROM employer WHERE i = :i";

        try {
            Map<String, Long> param = Map.of("i", i);
            Employer employer = template.queryForObject(sql, param, employerRowMapper());
            return Optional.of(employer);
        } catch (DataAccessException e) {
            log.error("find error", e);
            return Optional.empty();
        }
    }

    private RowMapper<Employer> employerRowMapper() {
        return BeanPropertyRowMapper.newInstance(Employer.class); // camel 변환 지원
//        return ((rs, rowNum) -> {
//            Employer employer = new Employer();
//            employer.setI(rs.getLong("i"));
//            employer.setId(rs.getString("id"));
//            employer.setPw(rs.getString("pw"));
//            employer.setEmail(rs.getString("email"));
//            employer.setBusinessNumber(rs.getString("business_number"));
//            employer.setExpirationPeriod(rs.getTimestamp("expiration_period").toLocalDateTime());
//            employer.setAgreeService(rs.getBoolean("agree_service"));
//            employer.setAgreePersonalInfo(rs.getBoolean("agree_personal_info"));
//            employer.setAgreeSms(rs.getBoolean("agree_sms"));
//            employer.setAgreeEmail(rs.getBoolean("agree_email"));
//            return employer;
//        });
    }
}
