package com.projectb.nogo.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@ToString
public class WorkerPhotoVO {

  private String photo;
  private MultipartFile photoContent;

//  public WorkerPhotoVO(WorkerDTO2 dto){
//      photoContent = dto.getPhotoContent();
//  }

}
