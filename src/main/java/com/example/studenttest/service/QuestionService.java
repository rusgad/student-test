package com.example.studenttest.service;

import com.example.studenttest.model.Question;

import java.util.ArrayList;

public interface QuestionService {
    ArrayList<Question> findByTestId(long id);
}
