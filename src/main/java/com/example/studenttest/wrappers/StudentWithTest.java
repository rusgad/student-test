package com.example.studenttest.wrappers;

public class StudentWithTest {
    private String studentName;
    private long testId;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public long getTestId() {
        return testId;
    }

    public void setTestId(long testId) {
        this.testId = testId;
    }

    public StudentWithTest() {
    }

    public StudentWithTest(String studentName, long testId) {
        this.studentName = studentName;
        this.testId = testId;
    }
}
