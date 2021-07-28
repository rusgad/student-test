package com.example.studenttest.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class QuestionDto {
    @NotNull(message = "id is null")
    private long id;
    @NotBlank(message = "question text is blank")
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
