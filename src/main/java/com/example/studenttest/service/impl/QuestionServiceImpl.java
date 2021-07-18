package com.example.studenttest.service.impl;

import com.example.studenttest.dto.QuestionDto;
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
    public ArrayList<QuestionDto> findByTestId(long id) {
        ArrayList<Question> questions = questionRepository.findAllByTestId(id);
        ArrayList<QuestionDto> questionDtoList = new ArrayList<>();
        for (Question question : questions) {
            QuestionDto questionDto = new QuestionDto(question.getId(), question.getQuestionText());
            questionDtoList.add(questionDto);
        }
        return questionDtoList;
    }
}
