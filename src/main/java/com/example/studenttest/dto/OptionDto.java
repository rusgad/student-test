package com.example.studenttest.dto;

import com.example.studenttest.model.Question;

public class OptionDto {
    private long id;
    private String optionText;
    private boolean isRight;
    private Question question;

    public OptionDto() {
    }

    public OptionDto(long id, String optionText, boolean isRight, Question question) {
        this.id = id;
        this.optionText = optionText;
        this.isRight = isRight;
        this.question = question;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
