package com.example.studenttest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tests")
public class TestController {
    @GetMapping
    public String getTestsPage() {
        return "testRestController";
    }
}
