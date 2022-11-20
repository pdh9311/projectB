package com.projectb.nogo.service;

import java.util.Map;

public interface LocalCodeService {

    // 시도 정보 리스트로 가져오기
    Map<String, String> findSidoList();

    // 시군구 정보 리스트로 가져오기
    Map<String, String> findSigunguList(String sidoCode);

    // 읍면동 정보 리스트로 가져오기
    Map<String, String> findEupmyeondongList(String sidoCode, String sigunguCode);

}
