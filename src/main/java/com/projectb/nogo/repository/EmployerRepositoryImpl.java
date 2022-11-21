package com.projectb.nogo.repository;

import com.projectb.nogo.domain.Employer;
import com.projectb.nogo.domain.EmployerInfo;
import com.projectb.nogo.domain.WorkerInfo;
import com.projectb.nogo.dto.EmployDto;
import com.projectb.nogo.dto.EmployerLoginForm;
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
import java.time.LocalDateTime;
import java.util.List;
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
    public void saveIdPw(Employer employer, Long empleroyInfoIdx) {
        String sql = "INSERT INTO tbl_employer(employer_id, employer_pw, employer_info_idx) VALUES (:employerId, :employerPw, :employerInfoIdx)";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("employerId", employer.getEmployerId())
                .addValue("employerPw", employer.getEmployerPw())
                .addValue("employerInfoIdx", empleroyInfoIdx);
        template.update(sql, param);
    }

    @Override
    public Optional<Employer> findByEmployerIdPw(EmployerLoginForm employerLoginForm) {
        String sql = "SELECT * FROM tbl_employer WHERE employer_id = :employerId AND employer_pw = :employerPw";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("employerId", employerLoginForm.getEmployerId())
                .addValue("employerPw", employerLoginForm.getEmployerPw());
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
    public List<WorkerInfo> findApplicants(List<Long> localCodeIdxes) {
        String sql = "SELECT Z.worker_info_idx, Z.worker_name, Z.worker_birth, " +
                "Z.worker_gender, Z.worker_email, Z.worker_phone, " +
                "Z.worker_career, Z.worker_photo_1, Z.worker_photo_2 " +
                "FROM tbl_apply_job AS Y " +
                "INNER JOIN tbl_worker_info AS Z " +
                "ON Y.worker_info_idx = Z.worker_info_idx ";

        int lcisize = localCodeIdxes.size();
        for (int i = 0; i < lcisize; i++) {
            if (i == 0) {
                sql += "WHERE ";
            }
            sql += "Y.local_code_idx = :localCodeIdx" + i + " ";
            if (lcisize != 0 && i != lcisize - 1) {
                sql += "OR ";
            }
        }
        sql += "GROUP BY Z.worker_info_idx";
        log.info("applicants SQL = {}", sql);

        MapSqlParameterSource param = new MapSqlParameterSource();
        for (int i = 0; i < lcisize; i++) {
            log.info("localCodeIdx = {}", localCodeIdxes.get(i));
            param.addValue("localCodeIdx" + i, localCodeIdxes.get(i));
        }

        List<WorkerInfo> workerInfoList = template.query(sql, param, applicantsRowMapper());
        return workerInfoList;
    }


    private RowMapper<WorkerInfo> applicantsRowMapper() {
        return (rs, rowNum) -> {
            WorkerInfo workerInfo = WorkerInfo.builder()
                    .workerInfoIdx(rs.getLong("worker_info_idx"))
                    .workerName(rs.getString("worker_name"))
                    .workerBirth(rs.getTimestamp("worker_birth").toLocalDateTime().toLocalDate())
                    .workerGender(rs.getString("worker_gender"))
                    .workerEmail(rs.getString("worker_email"))
                    .workerPhone(rs.getString("worker_phone"))
                    .workerCareer(rs.getString("worker_career"))
                    .workerPhoto1(rs.getString("worker_photo_1"))
                    .workerPhoto2(rs.getString("worker_photo_2"))
                    .build();
            return workerInfo;
        };
    }

    @Override
    public Boolean addEmploy(EmployDto employDto) {
        String sql = "INSERT INTO tbl_job_history(history_time, worker_info_idx, employer_info_idx, pay, worker_status, payment_status) " +
                "VALUES(:historyTime, :workerInfoIdx, :employerInfoIdx, :pay, :workerStatus, :paymentStatus)";

        log.info("addEmploy SQL = {}", sql);
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("historyTime", LocalDateTime.now())
                .addValue("workerInfoIdx", employDto.getWorkerInfoIdx())
                .addValue("employerInfoIdx", 1) // TODO: 나중에 세션에서 가져와야함.
                .addValue("pay", employDto.getWorkPay())
                .addValue("workerStatus", "고용됨")
                .addValue("paymentStatus", false);
        int update = template.update(sql, param);
        if (update != 1) {
            return false;
        }
        return true;
    }
}
