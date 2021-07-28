package com.example.studenttest.service;

import com.example.studenttest.dto.AnswerDto;
import com.example.studenttest.dto.QuestionDto;
import com.example.studenttest.dto.StudentDto;
import com.example.studenttest.model.Answer;
import java.util.ArrayList;

public interface AnswerService {
    void save(Answer answer);
    boolean existByStudentAndQuestion(StudentDto studentDto, QuestionDto questionDto);
    Answer findAnswerByStudentAndQuestion(StudentDto studentDto, QuestionDto questionDto);
    void saveAnswers(ArrayList<AnswerDto> pickedOptionsFromStudent);
    ArrayList<Long> findResult(StudentDto studentDto, long testId);
}
