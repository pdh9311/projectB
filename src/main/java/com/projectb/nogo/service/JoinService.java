package com.projectb.nogo.service;

import com.projectb.nogo.dto.CorporateDto;
import com.projectb.nogo.repository.JoinRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JoinService {

  private final JoinRepository joinRepository;

  public void save(CorporateDto corporateDto) {
    joinRepository.save(corporateDto);
  }
}
