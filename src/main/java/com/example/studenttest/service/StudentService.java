package com.example.studenttest.service;

import com.example.studenttest.dto.StudentDto;


public interface StudentService {
    void saveIfNotExist(StudentDto studentDto);
}
