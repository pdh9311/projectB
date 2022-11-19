package com.projectb.nogo.repository;


import com.projectb.nogo.domain.WorkerInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Slf4j
@Repository
public class JoinRepository {

  private final NamedParameterJdbcTemplate template;

  public JoinRepository(DataSource dataSource) {
    this.template = new NamedParameterJdbcTemplate(dataSource);
  }
  public WorkerInfo findWorkerAll( ) {
    String sql = "select * from tbl_worker";


    template.query(sql,(rs, rowNum) -> {
      System.out.println(rs);
              return rs;
            }
    );


    return null;
  }



//    KeyHolder keyHolder = new GeneratedKeyHolder();





















//
//  public void save( ) {
//    String sql = "INSERT INTO corporate(id, password, email, agree_service, agree_personal_info, agree_sms, agree_email, auth_method, auth_result, business_number, periods) " +
//        "VALUES (:id, :password, :email, :agreeService, :agreePersonalInfo, :agreeSms, :agreeEmail, :authMethod, :authResult, :businessNumber, :periods)";
//
//
//    //template.update(sql, param);
//
//  }
}
