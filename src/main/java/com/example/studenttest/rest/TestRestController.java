package com.example.studenttest.rest;

import com.example.studenttest.dto.TestDto;
import com.example.studenttest.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/test")
public class TestRestController {
    private final TestService testService;

    public TestRestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping
    public ArrayList<TestDto> getTests() {
        ArrayList<TestDto> testDtoList = testService.findAll();
        return testDtoList;
    }
}
