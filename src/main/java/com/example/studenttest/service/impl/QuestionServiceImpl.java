package com.example.studenttest.service.impl;

import com.example.studenttest.dto.QuestionDto;
import com.example.studenttest.model.Option;
import com.example.studenttest.model.Question;
import com.example.studenttest.repository.QuestionRepository;
import com.example.studenttest.service.OptionService;
import com.example.studenttest.service.QuestionService;
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
    public ArrayList<QuestionDto> findByTestId(long id) {
        ArrayList<Question> questions = questionRepository.findAllByTestId(id);
        ArrayList<QuestionDto> questionDtoList = new ArrayList<>();
        for (Question question : questions) {
            QuestionDto questionDto = new QuestionDto(question.getId(), question.getQuestionText());
            questionDtoList.add(questionDto);
        }
        return questionDtoList;
    }

//    @Override
//    public ArrayList<Question> getQuestionsByTestId(long testId) {
//        ArrayList<QuestionWithOptionsDto> questionWithOptionsDtoList = new ArrayList<>();
//        ArrayList<Question> questionsFromTest = findByTestId(testId);
//        for (Question question : questionsFromTest) {
//            ArrayList<Option> optionsForQuestion = optionService.findByQuestionId(question.getId());
//            Option rightOption = new Option();
//            Option pickedOption = new Option();
//            for (Option option : optionsForQuestion) {
//                if (option.isRight()) {
//                    rightOption = option;
//                }
//            }
//            questionWithOptionsDtoList.add(
//                    new QuestionWithOptionsDto(question, optionsForQuestion, pickedOption, rightOption.getOptionText())
//            );
//        }
//        return questionWithOptionsDtoList;
//    }
}
