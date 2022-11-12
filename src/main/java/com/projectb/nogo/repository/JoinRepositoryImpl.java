package com.projectb.nogo.repository;


import com.projectb.nogo.domain.Employer;
import lombok.extern.slf4j.Slf4j;
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
import java.util.Map;
import java.util.Optional;

@Slf4j
@Repository
public class JoinRepositoryImpl implements JoinRepository{

    private final NamedParameterJdbcTemplate template;

    public JoinRepositoryImpl(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public Long save(Employer employer) {
        String sql = "INSERT INTO tbl_employer(employer_id, employer_pw, email, business_number, expiration_period, agree_service, agree_personal_info, agree_sms, agree_email) " +
            "VALUES (:employerId, :employerPw, :email, :businessNumber, :expirationPeriod, :agreeService, :agreePersonalInfo, :agreeSms, :agreeEmail)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        SqlParameterSource param = new MapSqlParameterSource()
            .addValue("employerId", employer.getEmployerId())
            .addValue("employerPw", employer.getEmployerPw())
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
        Long idx = keyHolder.getKey().longValue();
//        employer.setIdx(idx);
//        return employer;
        return idx;
    }

    @Override
    public Optional<Employer> findById(Long idx) {
        String sql = "SELECT * FROM tbl_employer WHERE idx = :idx";

        Map<String, Long> param = Map.of("idx", idx);
        Employer employer = template.queryForObject(sql, param, employerRowMapper());   // 찾지 못하는 DataAccessException 언체크 예외가 발생할 수 있다.
        return Optional.of(employer);
    }

    private RowMapper<Employer> employerRowMapper() {
        return BeanPropertyRowMapper.newInstance(Employer.class); // camel 변환 지원
      /*return ((rs, rowNum) -> {
            Employer employer = new Employer();
            employer.setIdx(rs.getLong("idx"));
            employer.setEmployerId(rs.getString("id"));
            employer.setEmployerPw(rs.getString("pw"));
            employer.setEmail(rs.getString("email"));
            employer.setBusinessNumber(rs.getString("business_number"));
            employer.setExpirationPeriod(rs.getTimestamp("expiration_period").toLocalDateTime());
            employer.setAgreeService(rs.getBoolean("agree_service"));
            employer.setAgreePersonalInfo(rs.getBoolean("agree_personal_info"));
            employer.setAgreeSms(rs.getBoolean("agree_sms"));
            employer.setAgreeEmail(rs.getBoolean("agree_email"));
            return employer;
        });*/
    }
}
