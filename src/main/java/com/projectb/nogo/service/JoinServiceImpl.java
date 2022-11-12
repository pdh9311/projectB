package com.projectb.nogo.service;

import com.projectb.nogo.domain.Employer;
import com.projectb.nogo.repository.JoinRepository;
import com.projectb.nogo.repository.JoinRepositoryImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JoinServiceImpl implements JoinService {

    private final JoinRepository joinRepository;

    @Override
    public Employer save(Employer employer) {
        Long idx = joinRepository.save(employer);
        return joinRepository.findById(idx).get();
    }

}
