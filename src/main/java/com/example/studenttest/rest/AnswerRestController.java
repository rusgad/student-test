package com.example.studenttest.rest;

import com.example.studenttest.model.QuestionWithOptions;
import com.example.studenttest.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/answer")
public class AnswerRestController {
    @Autowired
    private AnswerRepository answerRepository;

    @PostMapping
    public void saveAnswers(@RequestBody ArrayList<QuestionWithOptions> questionWithOptions) {
        for (QuestionWithOptions answer : questionWithOptions) {
            System.out.println(answer.getPickedAnswer().getOptionText());
        }
    }
}
