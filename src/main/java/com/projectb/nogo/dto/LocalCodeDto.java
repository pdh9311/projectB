package com.projectb.nogo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class LocalCodeDto {
    private String sido;
    private String sigungu;
    private List<String> eupmyeondong = new ArrayList<>();
}
