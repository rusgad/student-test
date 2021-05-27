package com.example.studenttest.service.impl;

import com.example.studenttest.model.Answer;
import com.example.studenttest.model.Question;
import com.example.studenttest.model.Student;
import com.example.studenttest.repository.AnswerRepository;
import com.example.studenttest.service.AnswerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AnswerServiceImpl implements AnswerService {
    private AnswerRepository answerRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public void save(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    public ArrayList<Answer> findByStudent_UsernameAndTest_Id(String username, long testId) {
        return answerRepository.findByStudent_UsernameAndTest_Id(username, testId);
    }

    @Override
    public Answer findAnswerByStudentAndQuestion(Student student, Question question) {
        return answerRepository.findAnswerByStudentAndQuestion(student, question);
    }
}
