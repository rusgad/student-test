package com.example.studenttest.service;

import com.example.studenttest.model.Test;
import com.example.studenttest.repository.TestRepository;

import java.util.ArrayList;

public interface TestService {
    ArrayList<Test> findAll();
    Test findById(long id);
}
