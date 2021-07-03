package com.example.studenttest.service;

import com.example.studenttest.model.Answer;
import com.example.studenttest.model.Question;
import com.example.studenttest.model.Student;

import java.util.ArrayList;

public interface AnswerService {
    void save(Answer answer);
    ArrayList<Answer> findByStudent_UsernameAndTest_Id(String username, long testId);
    boolean existByStudentAndQuestion(Student student, Question question);
    Answer findAnswerByStudentAndQuestion(Student student, Question question);
}
