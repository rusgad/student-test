package com.example.studenttest.service;

import com.example.studenttest.model.Question;
import com.example.studenttest.dto.QuestionWithOptionsDto;

import java.util.ArrayList;

public interface QuestionService {
    ArrayList<Question> findByTestId(long id);
    ArrayList<QuestionWithOptionsDto> getQuestionsByTestId(long testId);
}
