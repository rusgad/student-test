package com.example.studenttest.mapper.impl;

import com.example.studenttest.dto.QuestionDto;
import com.example.studenttest.mapper.QuestionMapper;
import com.example.studenttest.model.Question;

public class QuestionMapperImpl implements QuestionMapper {
    @Override
    public QuestionDto toDto(Question question) {
        QuestionDto questionDto = new QuestionDto(question.getId(), question.getQuestionText(), question.getTest());
        return questionDto;
    }

    @Override
    public Question toEntity(QuestionDto questionDto) {
        Question question = new Question(questionDto.getId(), questionDto.getQuestionText(), questionDto.getTest());
        return question;
    }
}
