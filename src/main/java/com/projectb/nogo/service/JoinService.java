package com.projectb.nogo.service;

import com.projectb.nogo.dto.EmployerDto;
import com.projectb.nogo.repository.JoinRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JoinService {

  private final JoinRepository joinRepository;

  public void save(EmployerDto employerDto) {
    joinRepository.save(employerDto);
  }
}
