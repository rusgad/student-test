package com.example.studenttest.model;

import java.util.ArrayList;

public class QeustionWithOptions {
    private Question question;
    private ArrayList<Option> options;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }

    public QeustionWithOptions() {
    }

    public QeustionWithOptions(Question question, ArrayList<Option> options) {
        this.question = question;
        this.options = options;
    }
}
