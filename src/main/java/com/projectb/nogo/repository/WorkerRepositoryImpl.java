package com.projectb.nogo.repository;

import com.projectb.nogo.domain.Worker;
import com.projectb.nogo.domain.WorkerInfo;
import com.projectb.nogo.dto.WorkerLoginForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Repository
public class WorkerRepositoryImpl implements WorkerRepository {

    private final NamedParameterJdbcTemplate template;

    public WorkerRepositoryImpl(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public Long saveInfo(WorkerInfo workerInfo) {
        String sql = "INSERT INTO tbl_worker_info(worker_name, worker_birth, worker_gender, worker_email, worker_phone, agree_service, agree_personal_info, agree_sms, agree_email) " +
                "VALUES(:workerName, :workerBirth, :workerGender, :workerEmail, :workerPhone, :agreeService, :agreePersonalInfo, :agreeSms, :agreeEmail)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("workerName", workerInfo.getWorkerName())
                .addValue("workerBirth", workerInfo.getWorkerBirth())
                .addValue("workerGender", workerInfo.getWorkerGender())
                .addValue("workerEmail", workerInfo.getWorkerEmail())
                .addValue("workerPhone", workerInfo.getWorkerPhone())
                .addValue("agreeService", workerInfo.getAgreeService())
                .addValue("agreePersonalInfo", workerInfo.getAgreePersonalInfo())
                .addValue("agreeSms", workerInfo.getAgreeSms())
                .addValue("agreeEmail", workerInfo.getAgreeEmail());
        template.update(sql, param, keyHolder);
        Long idx = keyHolder.getKey().longValue();
        return idx;
    }

    @Override
    public void saveIdPw(Worker worker, Long workerInfoIdx) {
        String sql = "INSERT INTO tbl_worker(worker_id, worker_pw, worker_info_idx) VALUES(:workerId, :workerPw, :workerInfoIdx)";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("workerId", worker.getWorkerId())
                .addValue("workerPw", worker.getWorkerPw())
                .addValue("workerInfoIdx", workerInfoIdx);
        template.update(sql, param);
    }

    @Override
    public Optional<Worker> findByWorkerIdPw(WorkerLoginForm workerLoginForm) {
        String sql = "SELECT * FROM tbl_worker WHERE worker_id = :workerId AND worker_pw = :workerPw";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("workerId", workerLoginForm.getWorkerId())
                .addValue("workerPw", workerLoginForm.getWorkerPw());
        Worker worker = template.queryForObject(sql, param, workerRowMapper());
        return Optional.of(worker);
    }

    private RowMapper<Worker> workerRowMapper() {
//        return new BeanPropertyRowMapper<>(Worker.class);
        return (((rs, rowNum) -> {
            Worker worker = Worker.builder()
                    .loginType(rs.getInt("login_type"))
                    .workerId(rs.getString("worker_id"))
                    .workerPw(rs.getString("worker_pw"))
                    .workerInfoIdx(rs.getLong("worker_info_idx"))
                    .build();
            return worker;
        }));
    }

    @Override
    public Optional<WorkerInfo> findByWorkerInfoIdx(Long workerInfoIdx) {
        String sql = "SELECT * FROM tbl_worker_info WHERE worker_info_idx = :workerInfoIdx";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("workerInfoIdx", workerInfoIdx);
        WorkerInfo workerInfo = template.queryForObject(sql, param, workerInfoRowMapper());
        return Optional.of(workerInfo);
    }

    private RowMapper<WorkerInfo> workerInfoRowMapper() {
        return (((rs, rowNum) -> {
            WorkerInfo workerInfo = WorkerInfo.builder()
                    .workerInfoIdx(rs.getLong("worker_info_idx"))
                    .workerName(rs.getString("worker_name"))
                    .workerEmail(rs.getString("worker_email"))
                    .workerGender(rs.getString("worker_gender"))
                    .workerPhone(rs.getString("worker_phone"))
                    .workerBirth(rs.getTimestamp("worker_birth").toLocalDateTime().toLocalDate())
                    .build();
            return workerInfo;
        }));
    }

    @Override
    public Boolean applyJob(Long localCodeIdx, Long workerInfoIdx) {
        String sql = "INSERT INTO tbl_apply_job(apply_time, local_code_idx, worker_info_idx, apply_status) " +
                "VALUES(:applyTime, :localCodeIdx, :workerInfoIdx, :applyStatus)";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("applyTime", LocalDateTime.now())
                .addValue("localCodeIdx", localCodeIdx)
                .addValue("workerInfoIdx", workerInfoIdx)
                .addValue("applyStatus", false);

        int update = template.update(sql, param);
        if (update != 1) {
            return false;
        }
        return true;
    }

    @Override
    public void modifyApplyStatus(Long workerInfoIdx, Long localCodeIdx) {

        String sql = "UPDATE tbl_apply_job " +
                "SET apply_status = :applyStatus " +
                "WHERE worker_info_idx = :workerInfoIdx AND local_code_idx = :localCodeIdx";

        log.info("modifyApplyStatus SQL = {}", sql);
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("applyStatus", true)
                .addValue("workerInfoIdx", workerInfoIdx)
                .addValue("localCodeIdx", localCodeIdx);

        template.update(sql, param);
    }
}
