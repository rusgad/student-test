package com.example.studenttest.service.impl;

import com.example.studenttest.dto.TestDto;
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
    public ArrayList<TestDto> findAll() {
        ArrayList<Test> tests = (ArrayList<Test>) testRepository.findAll();
        ArrayList<TestDto> testDtoList = new ArrayList<>();
        for (Test test : tests) {
            TestDto testDto = new TestDto(test.getId(), test.getTitle());
            testDtoList.add(testDto);
        }
        return testDtoList;
    }
}
