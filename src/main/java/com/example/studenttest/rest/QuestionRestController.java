package com.example.studenttest.rest;

import com.example.studenttest.model.Question;
import com.example.studenttest.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/question")
public class QuestionRestController {
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/{testId}")
    public ArrayList<Question> getQuestions(@PathVariable long testId) {
        ArrayList<Question> questions = (ArrayList<Question>) questionRepository.findByTestId(testId);
        return questions;
    }
}
