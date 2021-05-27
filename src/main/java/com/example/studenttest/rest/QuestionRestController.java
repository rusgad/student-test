package com.example.studenttest.rest;

import com.example.studenttest.model.Option;
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

    private QuestionRepository questionRepository;
    private OptionRepository optionRepository;

    public QuestionRestController(QuestionRepository questionRepository, OptionRepository optionRepository) {
        this.questionRepository = questionRepository;
        this.optionRepository = optionRepository;
    }

    @GetMapping("/{testId}")
    public ArrayList<QuestionWithOptions> getQuestions(@PathVariable long testId) {
        ArrayList<QuestionWithOptions> questionWithOptions = new ArrayList<>();
        ArrayList<Question> questionsFromTest = questionRepository.findByTestId(testId);
        for (Question question : questionsFromTest) {
            ArrayList<Option> optionsForQuestion = optionRepository.findByQuestionId(question.getId());
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

    @GetMapping("/test")
    public void test() {
        ArrayList<Option> options = optionRepository.findByQuestionId(1);
        for (Option option : options) {
            System.out.println(option.getOptionText());
        }
    }
}
