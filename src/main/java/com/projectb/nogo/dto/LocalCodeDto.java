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
    private String sidoCode;
    private String sigunguCode;
    private List<String> eupmyeondongCodes = new ArrayList<>();
}