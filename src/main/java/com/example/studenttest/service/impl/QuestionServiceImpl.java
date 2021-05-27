package com.example.studenttest.service.impl;

import com.example.studenttest.model.Question;
import com.example.studenttest.repository.QuestionRepository;
import com.example.studenttest.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class QuestionServiceImpl implements QuestionService {
    private QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public ArrayList<Question> findByTestId(long id) {
        return questionRepository.findByTestId(id);
    }
}
