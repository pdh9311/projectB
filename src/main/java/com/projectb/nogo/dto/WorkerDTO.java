package com.projectb.nogo.dto;

import com.projectb.nogo.domain.WorkerHistoryVO;
import com.projectb.nogo.domain.WorkerPersonalVO;
import com.projectb.nogo.domain.WorkerPhotoVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@ToString
public class WorkerDTO {
    private WorkerPersonalVO personal;
    private List<WorkerHistoryVO> historyList;

//    private List<MultipartFile> file;
}
