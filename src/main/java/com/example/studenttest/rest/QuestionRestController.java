package com.example.studenttest.rest;

import com.example.studenttest.service.OptionService;
import com.example.studenttest.service.QuestionService;
import com.example.studenttest.model.QuestionWithOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/question")
public class QuestionRestController {
    private final QuestionService questionService;
    private final OptionService optionService;

    public QuestionRestController(QuestionService questionService, OptionService optionService) {
        this.questionService = questionService;
        this.optionService = optionService;
    }

    @GetMapping("/{testId}")
    public ArrayList<QuestionWithOptions> getQuestionsByTestId(@PathVariable long testId) {
        ArrayList<QuestionWithOptions> questionsWithOptions = questionService.getQuestionsByTestId(testId);
        return questionsWithOptions;
    }
}
