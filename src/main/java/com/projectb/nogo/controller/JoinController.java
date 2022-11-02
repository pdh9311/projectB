package com.projectb.nogo.controller;

import com.projectb.nogo.dto.CorporateDto;
import com.projectb.nogo.service.JoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/join")
@RequiredArgsConstructor
public class JoinController {

  private final JoinService joinService;

  @GetMapping("/corporate")
  public String joinCorporate() {
    return "joinCorporate";
  }

  @PostMapping("/corporate")
  public String CompleteJoinCorporate(CorporateDto corporateDto) {
    log.info("corporateDto={}", corporateDto);
    joinService.save(corporateDto);
    return "redirect:/";
  }
}
