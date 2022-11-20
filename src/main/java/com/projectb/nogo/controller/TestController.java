package com.projectb.nogo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @GetMapping("test")
    public String testForm() {
        return "test";
    }

    @PostMapping("test")
    @ResponseBody
    public List<String> test() {
        List<String> test = new ArrayList<>();
        test.add("a");
        test.add("b");
        test.add("c");
        return test;
    }
}
