package com.example.studenttest.rest;

import com.example.studenttest.model.Option;
import com.example.studenttest.model.QuestionWithOptions;
import com.example.studenttest.model.Question;
import com.example.studenttest.repository.OptionRepository;
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
    @Autowired
    private OptionRepository optionRepository;

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
