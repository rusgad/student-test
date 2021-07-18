package com.example.studenttest.dto;

public class OptionDto {
    private long id;
    private String optionText;
    private long questionId;

    public OptionDto() {
    }

    public OptionDto(long id, String optionText, long questionId) {
        this.id = id;
        this.optionText = optionText;
        this.questionId = questionId;
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

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }
}
