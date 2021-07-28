package com.example.studenttest.dto;

import javax.validation.constraints.NotNull;

public class AnswerDto {
    @NotNull(message = "student is null")
    private StudentDto student;
    @NotNull(message = "selected option is null")
    private OptionDto selectedOption;
    @NotNull(message = "test is null")
    private TestDto test;
    @NotNull(message = "question is null")
    private QuestionDto question;

    public AnswerDto(OptionDto selectedOption, TestDto test, QuestionDto question) {
        this.selectedOption = selectedOption;
        this.test = test;
        this.question = question;
    }

    public StudentDto getStudent() {
        return student;
    }

    public void setStudent(StudentDto student) {
        this.student = student;
    }

    public OptionDto getSelectedOption() {
        return selectedOption;
    }

    public TestDto getTest() {
        return test;
    }

    public void setTest(TestDto test) {
        this.test = test;
    }

    public QuestionDto getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDto question) {
        this.question = question;
    }
}
