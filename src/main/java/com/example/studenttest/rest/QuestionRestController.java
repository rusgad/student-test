package com.example.studenttest.rest;

import com.example.studenttest.model.Option;
import com.example.studenttest.service.impl.OptionServiceImpl;
import com.example.studenttest.service.impl.QuestionServiceImpl;
import com.example.studenttest.wrappers.QuestionWithOptions;
import com.example.studenttest.model.Question;
import com.example.studenttest.repository.OptionRepository;
import com.example.studenttest.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/api/question")
public class QuestionRestController {

    private QuestionServiceImpl questionService;
    private OptionServiceImpl optionService;

    public QuestionRestController(QuestionServiceImpl questionService, OptionServiceImpl optionService) {
        this.questionService = questionService;
        this.optionService = optionService;
    }

    @GetMapping("/{testId}")
    public ArrayList<QuestionWithOptions> getQuestions(@PathVariable long testId) {
        ArrayList<QuestionWithOptions> questionWithOptions = new ArrayList<>();
        ArrayList<Question> questionsFromTest = questionService.findByTestId(testId);
        for (Question question : questionsFromTest) {
            ArrayList<Option> optionsForQuestion = optionService.findByQuestionId(question.getId());
            Option rightOption = new Option();
            for (Option option : optionsForQuestion) {
                if (option.isRight()) {
                    rightOption = option;
                }
            }
            questionWithOptions.add(new QuestionWithOptions(question, optionsForQuestion, new Option(), rightOption.getOptionText()));
        }
        return questionWithOptions;
    }
}
