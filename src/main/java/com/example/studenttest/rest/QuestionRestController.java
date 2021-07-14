package com.example.studenttest.rest;

import com.example.studenttest.service.OptionService;
import com.example.studenttest.service.QuestionService;
import com.example.studenttest.dto.QuestionWithOptionsDto;
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
    public ArrayList<QuestionWithOptionsDto> getQuestionsByTestId(@PathVariable long testId) {
        ArrayList<QuestionWithOptionsDto> questionsWithOptionsDto = questionService.getQuestionsByTestId(testId);
        return questionsWithOptionsDto;
    }
}
