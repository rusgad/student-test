package com.example.studenttest.rest;

import com.example.studenttest.model.Test;
import com.example.studenttest.repository.TestRepository;
import com.example.studenttest.service.TestService;
import com.example.studenttest.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/api/test")
public class TestRestController {

    private TestServiceImpl testService;

    public TestRestController(TestServiceImpl testService) {
        this.testService = testService;
    }

    @GetMapping
    public ArrayList<Test> getTests() {
        ArrayList<Test> tests = (ArrayList<Test>) testService.findAll();
        return tests;
    }

    @GetMapping("/{id}")
    public Test getTest(@PathVariable long id) {
        Test test = testService.findById(id);
        return test;
    }
}
