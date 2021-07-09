package com.example.studenttest.service.impl;

import com.example.studenttest.model.Student;
import com.example.studenttest.repository.StudentRepository;
import com.example.studenttest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void saveIfNotExist(String username) {
        if (!studentRepository.existsByUsername(username)) {
            Student newStudent = new Student(username);
            studentRepository.save(newStudent);
        }
    }
//ControllerAdvice
    @Override
    public ArrayList<Student> findAll() {
        return (ArrayList<Student>) studentRepository.findAll();
    }

    @Override
    public Student findByUsername(String username) {
        return studentRepository.findByUsername(username);
    }
}
