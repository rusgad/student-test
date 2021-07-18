package com.example.studenttest.service;

import com.example.studenttest.dto.QuestionDto;

import java.util.ArrayList;

public interface QuestionService {
    ArrayList<QuestionDto> findByTestId(long id);
}
