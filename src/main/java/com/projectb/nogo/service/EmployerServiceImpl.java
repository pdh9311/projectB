package com.projectb.nogo.service;

import com.projectb.nogo.domain.Employer;
import com.projectb.nogo.domain.EmployerInfo;
import com.projectb.nogo.domain.LocalCode;
import com.projectb.nogo.dto.EmployerLoginDto;
import com.projectb.nogo.repository.EmployerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployerServiceImpl implements EmployerService {

    private final EmployerRepository employerRepository;

    @Transactional
    @Override
    public void save(EmployerInfo employerInfo, Employer employer) {
        Long idx = employerRepository.saveInfo(employerInfo);
        employerRepository.saveIdPw(employer, idx);
    }

    @Override
    public Optional<EmployerInfo> login(EmployerLoginDto employerLoginDto) {
        Employer employer = employerRepository.findByEmployerIdPw(employerLoginDto).get();
        return employerRepository.findByEmployerInfoIdx(employer.getEmployerInfoIdx());
    }

    @Override
    public Map<String, String> findSidoList() {
        List<LocalCode> sidoList = employerRepository.findSidoList();
        Map<String, String> codeAndName = new HashMap<>();
        for (LocalCode localCode : sidoList) {
            codeAndName.put(localCode.getSidoCode(), localCode.getSidoName());
        }
        return codeAndName;
    }

    @Override
    public Map<String, String> findSigunguList(String sido) {
        List<LocalCode> sigunguList = employerRepository.findSigunguList(sido);
        Map<String, String> codeAndName = new HashMap<>();
        for (LocalCode localCode : sigunguList) {
            codeAndName.put(localCode.getSigunguCode(), localCode.getSigunguName());
        }
        return codeAndName;
    }

    @Override
    public Map<String, String> findEupmyeondongList(String sigungu) {
        List<LocalCode> eupmyeondongList = employerRepository.findEupmyeondongList(sigungu);
        Map<String, String> codeAndName = new HashMap<>();
        for (LocalCode localCode : eupmyeondongList) {
            codeAndName.put(localCode.getEupmyeondongCode(), localCode.getEupmyeondongName());
        }
        return codeAndName;
    }
}
