package com.projectb.nogo.service;

import com.projectb.nogo.domain.WorkerInfo;
import com.projectb.nogo.repository.JoinRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    private JoinRepository joinRepository;

    public WorkerInfo createWorker(WorkerInfo worker) {
        return new WorkerInfo();
    }

    public WorkerInfo findWorkerAll() {
        return joinRepository.findWorkerAll();
    }

    public void saveAccount(WorkerAccountDto account) {
    }


}
