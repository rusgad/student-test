package com.example.studenttest.service;

import com.example.studenttest.dto.QuestionDto;
import com.example.studenttest.model.Question;

import java.util.ArrayList;

public interface QuestionService {
    ArrayList<QuestionDto> findByTestId(long id);
//    ArrayList<QuestionWithOptionsDto> getQuestionsByTestId(long testId);
}
