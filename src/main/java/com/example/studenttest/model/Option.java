package com.example.studenttest.model;

import javax.persistence.*;

@Entity
@Table(name = "options")
public class Option {
    @Id
    @GeneratedValue(generator = "options_sequence")
    private Long id;

    private String optionText;
    private boolean right;

    @OneToOne
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
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Option() {
    }

    public Option(Long id, String optionText, boolean right, Question question) {
        this.id = id;
        this.optionText = optionText;
        this.right = right;
        this.question = question;
    }
}
