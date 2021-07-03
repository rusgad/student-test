package com.example.studenttest.rest;

import com.example.studenttest.model.Student;
import com.example.studenttest.service.impl.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

    private final StudentServiceImpl studentService;

    public StudentRestController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = studentService.findAll();
        return students;
    }

    @GetMapping("/{username}")
    public Student getStudent(@PathVariable String username) {
        Student student = studentService.findByUsername(username);
        return student;
    }

    @PostMapping
    public void saveStudentIfNotExist(@RequestBody String username) {
        studentService.saveIfNotExist(username);
    }
}