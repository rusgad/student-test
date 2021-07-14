package com.example.studenttest.service.impl;

import com.example.studenttest.dto.StudentDto;
import com.example.studenttest.model.Student;
import com.example.studenttest.repository.StudentRepository;
import com.example.studenttest.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void saveIfNotExist(StudentDto studentDto) {
        if (!studentRepository.existsByUsernameAndPassword(studentDto.getUsername(), studentDto.getPassword())) {
            Student newStudent = new Student(studentDto.getUsername(), studentDto.getPassword());
            studentRepository.save(newStudent);
        }
    }
}
