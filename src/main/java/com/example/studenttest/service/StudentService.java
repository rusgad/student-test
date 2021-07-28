package com.example.studenttest.service;

import com.example.studenttest.dto.StudentDto;
import com.example.studenttest.exception.UserNotFoundException;


public interface StudentService {
    void loginIfExist(StudentDto studentDto) throws UserNotFoundException;
}
