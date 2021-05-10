package com.example.studenttest.model;

import javax.persistence.*;

@Entity
@Table(name = "results")
public class Result {
    @Id
    @GeneratedValue(generator = "result_sequence")
    private long id;

    private long testId;

    @OneToOne
    private Student student;


}
