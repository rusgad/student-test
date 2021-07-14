package com.example.studenttest.service.impl;

import com.example.studenttest.model.Answer;
import com.example.studenttest.model.Question;
import com.example.studenttest.model.Student;
import com.example.studenttest.repository.AnswerRepository;
import com.example.studenttest.repository.StudentRepository;
import com.example.studenttest.service.AnswerService;
import com.example.studenttest.dto.QuestionWithOptionsDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AnswerServiceImpl implements AnswerService {
    private AnswerRepository answerRepository;
    private StudentRepository studentRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository, StudentRepository studentRepository) {
        this.answerRepository = answerRepository;
        this.studentRepository = studentRepository;
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

    @Override
    public boolean existByStudentAndQuestion(Student student, Question question) {
        if (answerRepository.findAnswerByStudentAndQuestion(student, question) == null) {
            return false;
        }
        return true;
    }

    @Override
    public void saveAnswers(ArrayList<QuestionWithOptionsDto> answersFromStudent) {
        Student student = studentRepository.findByUsername(answersFromStudent.get(0).getStudentName());
        for (QuestionWithOptionsDto answer : answersFromStudent) {
            if (!existByStudentAndQuestion(student, answer.getQuestion())) {
                Answer newAnswer = new Answer(
                        student,
                        answer.getPickedAnswer(),
                        answer.getQuestion().getTest(),
                        answer.getQuestion()
                );
                save(newAnswer);
            } else {
                Answer existingAnswer = findAnswerByStudentAndQuestion(student, answer.getQuestion());
                existingAnswer.setSelectedOption(answer.getPickedAnswer());
                save(existingAnswer);
            }
        }
    }
}
