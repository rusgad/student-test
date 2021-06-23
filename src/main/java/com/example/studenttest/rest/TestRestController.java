package com.example.studenttest.rest;

import com.example.studenttest.model.Test;
import com.example.studenttest.service.impl.TestServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/api/test")
public class TestRestController {

    private final TestServiceImpl testService;

    public TestRestController(TestServiceImpl testService) {
        this.testService = testService;
    }

    @GetMapping
    public ArrayList<Test> getTests() {
        ArrayList<Test> tests = testService.findAll();
        return tests;
    }
}
