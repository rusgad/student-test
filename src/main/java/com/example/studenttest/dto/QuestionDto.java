package com.example.studenttest.dto;

public class QuestionDto {
    private long id;
    private String questionText;

    public QuestionDto(long id, String questionText) {
        this.id = id;
        this.questionText = questionText;
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
}
