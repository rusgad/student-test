package com.example.studenttest.rest;

import com.example.studenttest.dto.QuestionWithOptionsDto;
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

    public AnswerRestController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping
    public void saveAnswers(@RequestBody ArrayList<QuestionWithOptionsDto> answersFromStudent) {
        answerService.saveAnswers(answersFromStudent);
    }
}
