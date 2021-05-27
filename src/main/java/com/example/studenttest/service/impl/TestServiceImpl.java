package com.example.studenttest.service.impl;

import com.example.studenttest.model.Test;
import com.example.studenttest.repository.TestRepository;
import com.example.studenttest.service.TestService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TestServiceImpl implements TestService {
    private TestRepository testRepository;

    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public ArrayList<Test> findAll() {
        return (ArrayList<Test>) testRepository.findAll();
    }

    @Override
    public Test findById(long id) {
        return testRepository.findById(id);
    }
}
