package com.example.studenttest.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tests")
public class Test {
    @Id
    @GeneratedValue(generator = "tests_sequence")
    private Long id;

    @OneToMany
    private List<Question> questions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Test() {
    }

    public Test(Long id, List<Question> questions) {
        this.id = id;
        this.questions = questions;
    }
}
