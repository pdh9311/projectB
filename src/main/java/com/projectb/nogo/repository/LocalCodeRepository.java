package com.projectb.nogo.repository;

import com.projectb.nogo.domain.LocalCode;

import java.util.List;

public interface LocalCodeRepository {
    // 시도 정보 가져오기
    List<LocalCode> findSidoList();

    // 시군구 정보 가져오기
    List<LocalCode> findSigunguList(String sidoCode);

    // 읍면동 정보 가져오기
    List<LocalCode> findEupmyeondongList(String sidoCode, String sigunguCode);
}
