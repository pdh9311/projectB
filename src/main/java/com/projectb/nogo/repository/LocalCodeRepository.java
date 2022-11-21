package com.projectb.nogo.repository;

import com.projectb.nogo.domain.LocalCode;
import com.projectb.nogo.dto.LocalCodeDto;

import java.util.List;

public interface LocalCodeRepository {
    // 시도 정보 가져오기
    List<LocalCode> findSidoList();

    // 시군구 정보 가져오기
    List<LocalCode> findSigunguList(String sidoCode);

    // 읍면동 정보 가져오기
    List<LocalCode> findEupmyeondongList(String sidoCode, String sigunguCode);

    // 여러 지역 코드와 일치하는 키값 찾기
    List<Long> getLocalCodeIdxes(LocalCodeDto localCodeDto);

    // 하나의 지역 코드와 일치하는 키값 찾기
    Long getLocalCodeIdx(String sido, String sigungu, String eupmyeondong);
}
