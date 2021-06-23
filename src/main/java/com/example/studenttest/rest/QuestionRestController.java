package com.example.studenttest.rest;

import com.example.studenttest.model.Option;
import com.example.studenttest.model.Question;
import com.example.studenttest.service.impl.OptionServiceImpl;
import com.example.studenttest.service.impl.QuestionServiceImpl;
import com.example.studenttest.wrappers.QuestionWithOptions;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/api/question")
public class QuestionRestController {

    private final QuestionServiceImpl questionService;
    private final OptionServiceImpl optionService;

    public QuestionRestController(QuestionServiceImpl questionService, OptionServiceImpl optionService) {
        this.questionService = questionService;
        this.optionService = optionService;
    }

    @GetMapping("/{testId}")
    public ArrayList<QuestionWithOptions> getQuestions(@PathVariable long testId) {
        ArrayList<QuestionWithOptions> questionsWithOptions = new ArrayList<>();
        ArrayList<Question> questionsFromTest = questionService.findByTestId(testId);
        for (Question question : questionsFromTest) {
            ArrayList<Option> optionsForQuestion = optionService.findByQuestionId(question.getId());
            Option rightOption = new Option();
            Option pickedOption = new Option();
            for (Option option : optionsForQuestion) {
                if (option.isRight()) {
                    rightOption = option;
                }
            }
            questionsWithOptions.add(
                    new QuestionWithOptions(question, optionsForQuestion, pickedOption, rightOption.getOptionText())
            );
        }
        return questionsWithOptions;
    }
}
