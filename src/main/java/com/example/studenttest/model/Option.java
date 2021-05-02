package com.example.studenttest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Option {
    @Id
    @GeneratedValue(generator = "sex_gen")
    private Long id;

    private String optionText;
    private boolean isRight;

    @ManyToOne
    private Question question;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Option() {
    }

    public Option(Long id, String optionText, boolean isRight, Question question) {
        this.id = id;
        this.optionText = optionText;
        this.isRight = isRight;
        this.question = question;
    }
}
