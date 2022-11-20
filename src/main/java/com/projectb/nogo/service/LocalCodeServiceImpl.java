package com.projectb.nogo.service;

import com.projectb.nogo.domain.LocalCode;
import com.projectb.nogo.repository.LocalCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class LocalCodeServiceImpl implements LocalCodeService {

    private final LocalCodeRepository localCodeRepository;

    @Override
    public Map<String, String> findSidoList() {
        List<LocalCode> sidoList = localCodeRepository.findSidoList();
        Map<String, String> codeAndName = new HashMap<>();
        for (LocalCode localCode : sidoList) {
            codeAndName.put(localCode.getSidoCode(), localCode.getSidoName());
        }
        return codeAndName;
    }

    @Override
    public Map<String, String> findSigunguList(String sidoCode) {
        List<LocalCode> sigunguList = localCodeRepository.findSigunguList(sidoCode);
        Map<String, String> codeAndName = new HashMap<>();
        for (LocalCode localCode : sigunguList) {
            codeAndName.put(localCode.getSigunguCode(), localCode.getSigunguName());
        }
        return codeAndName;
    }

    @Override
    public Map<String, String> findEupmyeondongList(String sidoCode, String sigunguCode) {
        List<LocalCode> eupmyeondongList = localCodeRepository.findEupmyeondongList(sidoCode, sigunguCode);
        Map<String, String> codeAndName = new HashMap<>();
        for (LocalCode localCode : eupmyeondongList) {
            codeAndName.put(localCode.getEupmyeondongCode(), localCode.getEupmyeondongName());
        }
        return codeAndName;
    }
}
