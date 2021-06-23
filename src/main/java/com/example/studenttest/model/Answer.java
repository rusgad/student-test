package com.example.studenttest.model;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(generator = "answer_sequence")
    private long id;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Option selectedOption;
    @ManyToOne
    private Test test;
    @ManyToOne
    private Question question;

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

    public Answer() {
    }

    public Answer(Student student, Option selectedOption, Test test, Question question) {
        this.student = student;
        this.selectedOption = selectedOption;
        this.test = test;
        this.question = question;
    }
}
