package com.projectb.nogo.repository;


import com.projectb.nogo.domain.WorkerHistoryVO;
import com.projectb.nogo.domain.WorkerPersonalVO;
import com.projectb.nogo.domain.WorkerPhotoVO;
import com.projectb.nogo.dto.EmployerDto;
import com.projectb.nogo.dto.WorkerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

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

  public void workerPersonal(WorkerPersonalVO personal) {
    String sql = "INSERT INTO worker(" +
        "id, pw, email, phone, u_name, adr, adr_detail, agree_service, agree_personal_info, agree_sms, agree_email, period) " +
        "VALUES (:id,:pw, :email, :phone, :u_name, :adr, :adr_detail, :agree_service, :agree_personal_info, :agree_sms, :agree_email, :period)";

    MapSqlParameterSource param = new MapSqlParameterSource()
        .addValue("id", personal.getId())
        .addValue("pw", personal.getPassword())
        .addValue("email", personal.getEmail())
        .addValue("phone", personal.getPhone())
        .addValue("u_name", personal.getName())
        .addValue("adr", personal.getAdr())
        .addValue("adr_detail", personal.getAdrDetail())
        .addValue("agree_service", personal.getAgreeService())
        .addValue("agree_personal_info", personal.getAgreePersonalInfo())
        .addValue("agree_sms", personal.getAgreeSms())
        .addValue("agree_email", personal.getAgreeEmail())
        .addValue("period", personal.getPeriod());
    template.update(sql, param);
  }

  public void workerPhotos(List<WorkerPhotoVO> photoList) {
  }

  public void workerHistorys(List<WorkerHistoryVO> historyList) {
  }
}
