package com.example.studenttest.rest;

import com.example.studenttest.dto.QuestionDto;
import com.example.studenttest.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/question")
public class QuestionRestController {
    private final QuestionService questionService;

    public QuestionRestController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/{testId}")
    public ArrayList<QuestionDto> getQuestionsByTestId(@PathVariable long testId) {
        ArrayList<QuestionDto> questionDtoList = questionService.findByTestId(testId);
        return questionDtoList;
    }
}
