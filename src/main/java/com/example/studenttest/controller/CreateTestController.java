package com.example.studenttest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test/create")
public class CreateTestController {
    @GetMapping
    public String getTestCreatePage() {
        return "create-test";
    }
}
