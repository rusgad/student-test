package com.example.studenttest.rest;

import com.example.studenttest.model.Student;
import com.example.studenttest.service.StudentService;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {
    private final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = studentService.findAll();
        return students;
    }

    @PostMapping
    public void saveStudentIfNotExist(@RequestBody String username) {
        studentService.saveIfNotExist(username);
    }
}