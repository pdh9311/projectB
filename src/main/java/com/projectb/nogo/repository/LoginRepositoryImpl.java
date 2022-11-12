package com.projectb.nogo.repository;

import com.projectb.nogo.domain.Employer;
import com.projectb.nogo.dto.LoginEmployerDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Optional;

@Repository
public class LoginRepositoryImpl implements LoginRepository {

    private final NamedParameterJdbcTemplate template;

    public LoginRepositoryImpl(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public Optional<Employer> findByIdAndPw(LoginEmployerDto loginEmployerDto) {
        String employerId = loginEmployerDto.getEmployerId();
        String employerPw = loginEmployerDto.getEmployerPw();
        String sql = "SELECT * FROM tbl_employer WHERE employer_id = :employerId AND employer_pw = :employerPw";

        SqlParameterSource param = new MapSqlParameterSource()
            .addValue("employerId", employerId)
            .addValue("employerPw", employerPw);
        Employer employer = template.queryForObject(sql, param, employerRowMapper());
        return Optional.of(employer);
    }

    private RowMapper<Employer> employerRowMapper() {
        return BeanPropertyRowMapper.newInstance(Employer.class);
    }
}
