package com.projectb.nogo.repository;

import com.projectb.nogo.domain.Employer;
import com.projectb.nogo.domain.EmployerInfo;
import com.projectb.nogo.dto.EmployerLoginDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Optional;

@Slf4j
@Repository
public class EmployerRepositoryImpl implements EmployerRepository {

    private final NamedParameterJdbcTemplate template;

    public EmployerRepositoryImpl(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public Long saveInfo(EmployerInfo employerInfo) {
        String sql = "INSERT INTO tbl_employer_info(employer_email, employer_phone, business_number, expiration_date, agree_service, agree_personal_info, agree_sms, agree_email) " +
            "VALUES (:employerEmail, :employerPhone, :businessNumber, :expirationDate, :agreeService, :agreePersonalInfo, :agreeSms, :agreeEmail)";

        KeyHolder keyholder = new GeneratedKeyHolder();

        SqlParameterSource param = new MapSqlParameterSource()
            .addValue("employerEmail", employerInfo.getEmployerEmail())
            .addValue("employerPhone", employerInfo.getEmployerPhone())
            .addValue("businessNumber", employerInfo.getBusinessNumber())
            .addValue("expirationDate", employerInfo.getExpirationDate())
            .addValue("agreeService", employerInfo.getAgreeService())
            .addValue("agreePersonalInfo", employerInfo.getAgreePersonalInfo())
            .addValue("agreeSms", employerInfo.getAgreeSms())
            .addValue("agreeEmail", employerInfo.getAgreeEmail());
        template.update(sql, param, keyholder);
        return keyholder.getKey().longValue();
    }

    @Override
    public void saveIdPw(Employer employer, Long idx) {
        String sql = "INSERT INTO tbl_employer(employer_id, employer_pw, employer_info_idx) VALUES (:employerId, :employerPw, :employerInfoIdx)";
        SqlParameterSource param = new MapSqlParameterSource()
            .addValue("employerId", employer.getEmployerId())
            .addValue("employerPw", employer.getEmployerPw())
            .addValue("employerInfoIdx", idx);
        template.update(sql, param);
    }

    @Override
    public Optional<Employer> findByEmployerIdPw(EmployerLoginDto employerLoginDto) {
        String id = employerLoginDto.getEmployerId();
        String pw = employerLoginDto.getEmployerPw();
        log.info("employerId = {}", employerLoginDto.getEmployerId());
        log.info("employerPw = {}", employerLoginDto.getEmployerPw());
        String sql = "SELECT * FROM tbl_employer WHERE employer_id = :employerId AND employer_pw = :employerPw";
        SqlParameterSource param = new MapSqlParameterSource()
            .addValue("employerId", id)
            .addValue("employerPw", pw);
        Employer employer = template.queryForObject(sql, param, employerRowMapper());
        log.info("employer = {}", employer);
        return Optional.of(employer);
    }

    @Override
    public Optional<EmployerInfo> findByEmployerInfoIdx(Long employerInfoIdx) {
        String sql = "SELECT * FROM tbl_employer_info WHERE employer_info_idx = :employerInfoIdx";

        SqlParameterSource param = new MapSqlParameterSource()
            .addValue("employerInfoIdx", employerInfoIdx);
        EmployerInfo employerInfo = template.queryForObject(sql, param, employerInfoRowMapper());
        return Optional.of(employerInfo);
    }

    private RowMapper<Employer> employerRowMapper() {
        return BeanPropertyRowMapper.newInstance(Employer.class);
    }

    private RowMapper<EmployerInfo> employerInfoRowMapper() {
        return BeanPropertyRowMapper.newInstance(EmployerInfo.class);
    }
}
