package com.example.studenttest.model;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(generator = "question_sequence")
    private long id;
    private String questionText;
    @OneToOne
    private Test test;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Question() {
    }

    public Question(String questionText, Test test) {
        this.questionText = questionText;
        this.test = test;
    }
}
