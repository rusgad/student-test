package com.example.studenttest.dto;

import com.example.studenttest.model.Test;

public class QuestionDto {
    private long id;
    private String questionText;
    private Test test;

    public QuestionDto(Long id, String questionText, Test test) {
        this.id = id;
        this.questionText = questionText;
        this.test = test;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
