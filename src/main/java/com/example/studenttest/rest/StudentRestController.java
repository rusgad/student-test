package com.example.studenttest.rest;

import com.example.studenttest.model.Student;
import com.example.studenttest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = (ArrayList<Student>) studentRepository.findAll();
        return students;
    }

    @PostMapping
    public void saveUserIfNotExist(@RequestBody String username) {
        Student student = studentRepository.findByUsername(username);
        if (student == null) {
            Student newStudent = new Student(username, "user");
            studentRepository.save(newStudent);
        }
    }
}