package com.projectb.nogo.service;

import com.projectb.nogo.domain.WorkerHistoryVO;
import com.projectb.nogo.domain.WorkerPersonalVO;
import com.projectb.nogo.domain.WorkerPhotoVO;
import com.projectb.nogo.dto.EmployerDto;
import com.projectb.nogo.dto.WorkerDTO;
import com.projectb.nogo.repository.JoinRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class JoinService {

  private final JoinRepository joinRepository;

  public void save(EmployerDto employerDto) {
    joinRepository.save(employerDto);
  }


  public void workerPersonal(WorkerPersonalVO personal) {
    joinRepository.workerPersonal(personal);
  }

  public void workerPhotos(List<WorkerPhotoVO> photoList) {
    joinRepository.workerPhotos(photoList);
  }

  public void workerHistorys(List<WorkerHistoryVO> historyList) {
    joinRepository.workerHistorys(historyList);
  }
}
