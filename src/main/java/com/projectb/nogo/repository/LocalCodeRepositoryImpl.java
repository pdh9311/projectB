package com.projectb.nogo.repository;

import com.projectb.nogo.domain.LocalCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@Repository
public class LocalCodeRepositoryImpl implements LocalCodeRepository {

    private final NamedParameterJdbcTemplate template;

    public LocalCodeRepositoryImpl(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
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
    public List<LocalCode> findSigunguList(String sidoCode) {
        log.info("sidoCode = {}", sidoCode);
        String sql = "SELECT sigungu_code, sigungu_name FROM tbl_local_code WHERE sido_code = :sidoCode GROUP BY sigungu_code";
        SqlParameterSource param = new MapSqlParameterSource("sidoCode", sidoCode);
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
    public List<LocalCode> findEupmyeondongList(String sidoCode, String sigunguCode) {
        log.info("sigunguCode = {}", sigunguCode);
        String sql = "SELECT eupmyeondong_code, eupmyeondong_name FROM tbl_local_code WHERE sido_code = :sidoCode AND sigungu_code = :sigunguCode GROUP BY eupmyeondong_code";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("sidoCode", sidoCode)
                .addValue("sigunguCode", sigunguCode);
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
