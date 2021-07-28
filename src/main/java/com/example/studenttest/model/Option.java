package com.example.studenttest.model;

import javax.persistence.*;

@Entity
@Table(name = "options")
public class Option {
    @Id
    @GeneratedValue(generator = "option_sequence")
    private long id;
    private String optionText;
    private boolean isRight;
    @ManyToOne
    private Question question;

    public Option() {
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
