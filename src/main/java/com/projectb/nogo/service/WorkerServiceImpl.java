package com.projectb.nogo.service;

import com.projectb.nogo.domain.Worker;
import com.projectb.nogo.domain.WorkerInfo;
import com.projectb.nogo.dto.WorkerLoginForm;
import com.projectb.nogo.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;

    @Transactional
    @Override
    public void save(WorkerInfo workerInfo, Worker worker) {
        Long idx = workerRepository.saveInfo(workerInfo);
        log.info("worker idx = {}", idx);
        workerRepository.saveIdPw(worker, idx);
    }

    @Override
    public Optional<WorkerInfo> login(WorkerLoginForm workerLoginForm) {
        Worker worker = workerRepository.findByWorkerIdPw(workerLoginForm).get();
        return workerRepository.findByWorkerInfoIdx(worker.getWorkerInfoIdx());
    }
}
