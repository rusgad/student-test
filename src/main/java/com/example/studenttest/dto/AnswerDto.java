package com.example.studenttest.dto;

import com.example.studenttest.model.Option;
import com.example.studenttest.model.Question;
import com.example.studenttest.model.Student;
import com.example.studenttest.model.Test;

import javax.persistence.ManyToOne;

public class AnswerDto {
    private StudentDto student;
    private OptionDto selectedOption;
    private TestDto test;
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

    public void setSelectedOption(OptionDto selectedOption) {
        this.selectedOption = selectedOption;
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
