package com.example.studenttest.model;

import java.util.ArrayList;

public class ResultOfTesting {
    private String username;
    private ArrayList<QeustionWithOptions> estimate;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<QeustionWithOptions> getEstimate() {
        return estimate;
    }

    public void setEstimate(ArrayList<QeustionWithOptions> estimate) {
        this.estimate = estimate;
    }

    public ResultOfTesting() {
    }

    public ResultOfTesting(String username, ArrayList<QeustionWithOptions> estimate) {
        this.username = username;
        this.estimate = estimate;
    }
}
