package com.example.studenttest.rest;

import com.example.studenttest.dto.StudentDto;
import com.example.studenttest.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {
    private final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void saveStudentIfNotExist(@RequestBody StudentDto studentDto) {
        studentService.saveIfNotExist(studentDto);
    }
}