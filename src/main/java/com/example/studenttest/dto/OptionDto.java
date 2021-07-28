package com.example.studenttest.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OptionDto {
    @NotNull(message = "id is null")
    @Min(value = 1, message = "id is less than 1")
    private long id;
    @NotBlank(message = "option text is blank")
    private String optionText;
    @NotNull(message = "question id is null")
    private long questionId;

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
