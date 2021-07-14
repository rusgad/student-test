package com.example.studenttest.service;

import com.example.studenttest.dto.TestDto;
import java.util.ArrayList;

public interface TestService {
    ArrayList<TestDto> findAll();
}
