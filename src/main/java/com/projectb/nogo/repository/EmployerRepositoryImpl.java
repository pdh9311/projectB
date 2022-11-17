package com.projectb.nogo.repository;

import com.projectb.nogo.domain.Employer;
import com.projectb.nogo.domain.EmployerInfo;
import com.projectb.nogo.domain.LocalCode;
import com.projectb.nogo.dto.EmployerLoginDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        String sql = "SELECT * FROM tbl_employer WHERE employer_id = :employerId AND employer_pw = :employerPw";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("employerId", id)
                .addValue("employerPw", pw);
        Employer employer = template.queryForObject(sql, param, employerRowMapper());
        return Optional.of(employer);
    }

    private RowMapper<Employer> employerRowMapper() {
        //return BeanPropertyRowMapper.newInstance(Employer.class);
        return (((rs, rowNum) -> {
            Employer employer = Employer.builder()
                    .employerId(rs.getString("employer_id"))
                    .employerPw(rs.getString("employer_pw"))
                    .employerStatus(rs.getBoolean("employer_status"))
                    .employerInfoIdx(rs.getLong("employer_info_idx"))
                    .build();
            return employer;
        }));
    }

    @Override
    public Optional<EmployerInfo> findByEmployerInfoIdx(Long employerInfoIdx) {
        String sql = "SELECT * FROM tbl_employer_info WHERE employer_info_idx = :employerInfoIdx";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("employerInfoIdx", employerInfoIdx);
        EmployerInfo employerInfo = template.queryForObject(sql, param, employerInfoRowMapper());
        return Optional.of(employerInfo);
    }

    private RowMapper<EmployerInfo> employerInfoRowMapper() {
        return BeanPropertyRowMapper.newInstance(EmployerInfo.class);
    }

    @Override
    public List<LocalCode> findSidoList() {
        String sql = "SELECT sido_code, sido_name FROM tbl_local_code GROUP BY sido_code";
        return template.query(sql, sidoRowMapper());
    }

    private RowMapper<LocalCode> sidoRowMapper() {
        return ((rs, rowNum) -> {
            LocalCode localCode = LocalCode.builder()
                    .sidoCode(rs.getString("sido_code"))
                    .sidoName(rs.getString("sido_name"))
                    .build();
            return localCode;
        });
    }

    @Override
    public List<LocalCode> findSigunguList(String code) {
        String sql = "SELECT sigungu_code, sigungu_name FROM tbl_local_code WHERE sido_code = :code GROUP BY sigungu_code";
        SqlParameterSource param = new MapSqlParameterSource("code", code);
        return template.query(sql, param, sigunguRowMapper());
    }

    private RowMapper<LocalCode> sigunguRowMapper() {
        return ((rs, rowNum) -> {
            LocalCode localCode = LocalCode.builder()
                    .sigunguCode(rs.getString("sigungu_code"))
                    .sigunguName(rs.getString("sigungu_name"))
                    .build();
            return localCode;
        });
    }

    @Override
    public List<LocalCode> findEupmyeondongList(String code) {
        String sql = "SELECT eupmyeondong_code, eupmyeondong_name FROM tbl_local_code WHERE sigungu_code = :code GROUP BY eupmyeondong_code";
        SqlParameterSource param = new MapSqlParameterSource("code", code);
        return template.query(sql, param, eupmyeondongRowMapper());
    }

    private RowMapper<LocalCode> eupmyeondongRowMapper() {
        return ((rs, rowNum) -> {
            LocalCode localCode = LocalCode.builder()
                    .eupmyeondongCode(rs.getString("eupmyeondong_code"))
                    .eupmyeondongName(rs.getString("eupmyeondong_name"))
                    .build();
            return localCode;
        });
    }


}
