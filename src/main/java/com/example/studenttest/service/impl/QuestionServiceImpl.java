package com.example.studenttest.service.impl;

import com.example.studenttest.model.Option;
import com.example.studenttest.model.Question;
import com.example.studenttest.repository.QuestionRepository;
import com.example.studenttest.service.OptionService;
import com.example.studenttest.service.QuestionService;
import com.example.studenttest.model.QuestionWithOptions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class QuestionServiceImpl implements QuestionService {
    private QuestionRepository questionRepository;
    private OptionService optionService;

    public QuestionServiceImpl(QuestionRepository questionRepository, OptionService optionService) {
        this.questionRepository = questionRepository;
        this.optionService = optionService;
    }

    @Override
    public ArrayList<Question> findByTestId(long id) {
        return questionRepository.findByTestId(id);
    }

    @Override
    public ArrayList<QuestionWithOptions> getQuestionsByTestId(long testId) {
        ArrayList<QuestionWithOptions> questionsWithOptions = new ArrayList<>();
        ArrayList<Question> questionsFromTest = findByTestId(testId);
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
