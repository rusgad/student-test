package com.example.studenttest.service;

import com.example.studenttest.dto.StudentDto;
import com.example.studenttest.model.Student;


public interface StudentService {
    Student findByUsernameAndPassword(String username, String password);
    void saveIfNotExist(StudentDto studentDto);
}
