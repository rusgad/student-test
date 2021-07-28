package com.example.studenttest.service.impl;

import com.example.studenttest.dto.StudentDto;
import com.example.studenttest.exception.UserNotFoundException;
import com.example.studenttest.model.Student;
import com.example.studenttest.repository.StudentRepository;
import com.example.studenttest.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void loginIfExist(StudentDto studentDto) throws UserNotFoundException {
        if (!studentRepository.existsByUsernameAndPassword(studentDto.getUsername(), studentDto.getPassword()))
            throw new UserNotFoundException("user is not exist");
    }
}
