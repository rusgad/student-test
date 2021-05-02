package com.example.studenttest.model;

import javax.persistence.*;

@Entity
@Table(name = "tests")
public class Test {
    @Id
    @GeneratedValue(generator = "tests_sequence")
    private Long id;

    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Test() {
    }

    public Test(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
