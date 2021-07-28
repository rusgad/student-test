package com.example.studenttest.model;

import javax.persistence.*;

@Entity
@Table(name = "tests")
public class Test {
    @Id
    @GeneratedValue(generator = "test_sequence")
    private long id;
    private String title;

    public Test() {
    }

    public Test(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
