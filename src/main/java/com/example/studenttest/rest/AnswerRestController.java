package com.example.studenttest.rest;

import com.example.studenttest.model.QuestionWithOptions;
import com.example.studenttest.service.AnswerService;
import com.example.studenttest.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping
    public void saveAnswers(@RequestBody ArrayList<QuestionWithOptions> answersFromStudent) {
        answerService.saveAnswers(answersFromStudent);
    }
}
