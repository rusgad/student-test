package com.example.studenttest.rest;

import com.example.studenttest.model.Test;
import com.example.studenttest.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/api/test")
public class TestRestController {

    private TestRepository testRepository;

    public TestRestController(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @GetMapping
    public ArrayList<Test> getTests() {
        ArrayList<Test> tests = (ArrayList<Test>) testRepository.findAll();
        return tests;
    }

    @GetMapping("/{id}")
    public Test getTest(@PathVariable long id) {
        Test test = testRepository.findById(id);
        return test;
    }
}
