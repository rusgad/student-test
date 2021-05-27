package com.example.studenttest.service;

import com.example.studenttest.model.Student;

import java.util.ArrayList;

public interface StudentService {
    ArrayList<Student> findAll();
    void save(Student student);
    Student findByUsername(String username);
}
