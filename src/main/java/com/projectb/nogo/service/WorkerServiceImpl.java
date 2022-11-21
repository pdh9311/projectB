package com.projectb.nogo.service;

import com.projectb.nogo.domain.Worker;
import com.projectb.nogo.domain.WorkerInfo;
import com.projectb.nogo.dto.LocalCodeDto;
import com.projectb.nogo.dto.WorkerLoginForm;
import com.projectb.nogo.repository.LocalCodeRepository;
import com.projectb.nogo.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;
    private final LocalCodeRepository localCodeRepository;

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

    @Transactional
    @Override
    public Boolean applyJob(LocalCodeDto localCodeDto) {
        // 지역 코드와 일치하는 키값 찾기
        List<Long> localCodeIdxes = localCodeRepository.getLocalCodeIdxes(localCodeDto);
        // TODO: 만약 tbl_apply_job에 오늘날짜와 지역코드키값, 지원자키값이 이미 있는 경우에 대한 처리가 필요함

        // 찾은 키값으로 지원하기
        int lcisize = localCodeIdxes.size();
        for (int i = 0; i < lcisize; i++) {
            Boolean result = workerRepository.applyJob(localCodeIdxes.get(i), 1L);
            if (result == false) {
                return false;
            }
        }
        return true;
    }


}
