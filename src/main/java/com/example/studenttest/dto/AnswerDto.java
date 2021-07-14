package com.example.studenttest.dto;

import com.example.studenttest.model.Option;
import com.example.studenttest.model.Question;
import com.example.studenttest.model.Student;
import com.example.studenttest.model.Test;

import javax.persistence.ManyToOne;

public class AnswerDto {
    private long id;
    private Student student;
    private Option selectedOption;
    private Test test;
    private Question question;

    public AnswerDto(long id, Student student, Option selectedOption, Test test, Question question) {
        this.id = id;
        this.student = student;
        this.selectedOption = selectedOption;
        this.test = test;
        this.question = question;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Option getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(Option selectedOption) {
        this.selectedOption = selectedOption;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
