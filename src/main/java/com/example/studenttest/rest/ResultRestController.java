package com.example.studenttest.rest;

import com.example.studenttest.model.QeustionWithOptions;
import com.example.studenttest.model.ResultOfTesting;
import com.example.studenttest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/result")
public class ResultRestController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public void saveTestResult(@RequestBody ResultOfTesting result) {
        String username = result.getUsername().substring(0, result.getUsername().length());
        ArrayList<QeustionWithOptions> testAnswers = result.getEstimate();


    }
}
