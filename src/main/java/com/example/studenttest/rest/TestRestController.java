package com.example.studenttest.rest;

import com.example.studenttest.model.Test;
import com.example.studenttest.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/test")
public class TestRestController {
    @Autowired
    private TestRepository testRepository;

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
