package com.projectb.nogo.controller;

import com.projectb.nogo.service.LocalCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class LocalCodeController {

    private final LocalCodeService localCodeService;

    @PostMapping("/sido")
    public Map<String, String> sidoList() {
        return localCodeService.findSidoList();
    }

    @PostMapping("/sigungu")
    public Map<String, String> sigunguList(@RequestParam("sidoCode") String sidoCode) {
        return localCodeService.findSigunguList(sidoCode);
    }

    @PostMapping("/eupmyeondong")
    public Map<String, String> eupmyeondongList(@RequestParam("sidoCode") String sidoCode,
                                                @RequestParam("sigunguCode") String sigunguCode) {
        return localCodeService.findEupmyeondongList(sidoCode, sigunguCode);
    }
}
