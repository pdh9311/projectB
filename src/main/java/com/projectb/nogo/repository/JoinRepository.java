package com.projectb.nogo.repository;

import com.projectb.nogo.domain.Employer;
import com.projectb.nogo.dto.LoginEmployerDto;

import java.util.Optional;

public interface JoinRepository {
    Long save(Employer employer);

    Optional<Employer> findById(Long idx);

}
