package com.example.studenttest.wrappers;

import com.example.studenttest.model.Student;

public class StudentAndTestId {
    private String username;
    private long testId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getTestId() {
        return testId;
    }

    public void setTestId(long testId) {
        this.testId = testId;
    }

    public StudentAndTestId() {
    }

    public StudentAndTestId(String username, long testId) {
        this.username = username;
        this.testId = testId;
    }
}
