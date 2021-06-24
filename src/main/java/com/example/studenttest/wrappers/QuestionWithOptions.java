package com.example.studenttest.wrappers;

import com.example.studenttest.model.Option;
import com.example.studenttest.model.Question;

import java.util.ArrayList;

public class QuestionWithOptions {
    private String studentName;
    private Question question;
    private ArrayList<Option> options;
    private Option pickedAnswer;
    private String rightAnswer;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

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

    public QuestionWithOptions() {
    }

    public QuestionWithOptions(Question question, ArrayList<Option> options, Option pickedAnswer, String rightAnswer) {
        this.studentName = null;
        this.question = question;
        this.options = options;
        this.pickedAnswer = pickedAnswer;
        this.rightAnswer = rightAnswer;
    }
}
