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

    public Answer() {
    }

    public Answer(long id, Student student, Option selectedOption) {
        this.id = id;
        this.student = student;
        this.selectedOption = selectedOption;
    }
}
