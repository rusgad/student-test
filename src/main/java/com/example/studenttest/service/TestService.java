package com.example.studenttest.service;

import com.example.studenttest.model.Test;

import java.util.ArrayList;

public interface TestService {
    ArrayList<Test> findAll();
    Test findById(long id);
}
