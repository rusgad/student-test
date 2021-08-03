package com.example.studenttest.service.impl;

import com.example.studenttest.dto.*;
import com.example.studenttest.model.*;
import com.example.studenttest.repository.*;
import com.example.studenttest.service.AnswerService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class AnswerServiceImpl implements AnswerService {
    private AnswerRepository answerRepository;
    private StudentRepository studentRepository;
    private QuestionRepository questionRepository;
    private OptionRepository optionRepository;
    private TestRepository testRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository, StudentRepository studentRepository,
                             QuestionRepository questionRepository, OptionRepository optionRepository,
                             TestRepository testRepository) {
        this.answerRepository = answerRepository;
        this.studentRepository = studentRepository;
        this.questionRepository = questionRepository;
        this.optionRepository = optionRepository;
        this.testRepository = testRepository;
    }

    @Override
    public void save(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    public void saveAnswers(ArrayList<AnswerDto> pickedOptionsFromStudent) {
        StudentDto studentDto = pickedOptionsFromStudent.get(0).getStudent();
        for (AnswerDto answer : pickedOptionsFromStudent) {
            if (!existByStudentAndQuestion(studentDto, answer.getQuestion())) {
                Student student = studentRepository.findByUsernameAndPassword(studentDto.getUsername(), studentDto.getPassword());
                Option option = optionRepository.findById(answer.getSelectedOption().getId());
                Test test = new Test(answer.getTest().getId(), answer.getTest().getTitle());
                Question question = new Question(answer.getQuestion().getId(), answer.getQuestion().getQuestionText(), test);
                Answer newAnswer = new Answer(student, option, test, question);
                save(newAnswer);
            } else {
                Answer existingAnswer = findAnswerByStudentAndQuestion(studentDto, answer.getQuestion());
                Option option = optionRepository.findById(answer.getSelectedOption().getId());
                existingAnswer.setPickedOption(option);
                save(existingAnswer);
            }
        }
    }

    @Override
    public boolean existByStudentAndQuestion(StudentDto studentDto, QuestionDto questionDto) {
        Student student = studentRepository.findByUsernameAndPassword(studentDto.getUsername(), studentDto.getPassword());
        Question question = questionRepository.findById(questionDto.getId());

        if (answerRepository.findAnswerByStudentAndQuestion(student, question) == null) {
            return false;
        }
        return true;
    }

    @Override
    public Answer findAnswerByStudentAndQuestion(StudentDto studentDto, QuestionDto questionDto) {
        Student student = studentRepository.findByUsernameAndPassword(studentDto.getUsername(), studentDto.getPassword());
        Question question = questionRepository.findById(questionDto.getId());
        return answerRepository.findAnswerByStudentAndQuestion(student, question);
    }

    @Override
    public ArrayList<Long> findResult(StudentDto studentDto, long testId) {
        Student student = studentRepository.findByUsernameAndPassword(studentDto.getUsername(), studentDto.getPassword());

        ArrayList<Answer> answers = answerRepository.findByStudentAndTestId(student, testId);
        ArrayList<Long> rightAnsweredQuestions = new ArrayList<>();

        for (Answer answer : answers) {
            if (answer.getPickedOption().isRight()) {
                rightAnsweredQuestions.add(answer.getQuestion().getId());
            }
        }

        return rightAnsweredQuestions;
    }
}