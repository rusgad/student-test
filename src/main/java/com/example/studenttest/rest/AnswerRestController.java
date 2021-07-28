package com.example.studenttest.rest;

import com.example.studenttest.dto.AnswerDto;
import com.example.studenttest.dto.StudentDto;
import com.example.studenttest.model.Student;
import com.example.studenttest.service.AnswerService;
import com.example.studenttest.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/answer")
public class AnswerRestController {
    private final AnswerService answerService;
    private final StudentService studentService;

    public AnswerRestController(AnswerService answerService, StudentService studentService) {
        this.answerService = answerService;
        this.studentService = studentService;
    }

    @PostMapping("/{testId}")
    public ArrayList<Long> getResult(@PathVariable long testId, @RequestBody StudentDto studentDto) {
        return answerService.findResult(studentDto, testId);
    }

    @PostMapping
    public void saveAnswers(@RequestBody ArrayList<AnswerDto> pickedOptionsFromStudent) {
        answerService.saveAnswers(pickedOptionsFromStudent);
    }
}
