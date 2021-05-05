package com.example.studenttest.model;

import java.util.ArrayList;

public class QeustionWithOptions {
    private Question question;
    private ArrayList<Option> options;
    private Option pickedAnswer;
    private String rightAnswer;

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

    public Option getPickedAnswer() {
        return pickedAnswer;
    }

    public void setPickedAnswer(Option pickedAnswer) {
        this.pickedAnswer = pickedAnswer;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public QeustionWithOptions() {
    }

    public QeustionWithOptions(Question question, ArrayList<Option> options, Option pickedAnswer, String rightAnswer) {
        this.question = question;
        this.options = options;
        this.pickedAnswer = pickedAnswer;
        this.rightAnswer = rightAnswer;
    }
}
