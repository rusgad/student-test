package com.example.studenttest.rest;

import com.example.studenttest.model.Answer;
import com.example.studenttest.model.AnswerFromUser;
import com.example.studenttest.model.Student;
import com.example.studenttest.repository.AnswerRepository;
import com.example.studenttest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/answer")
public class AnswerRestController {
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public void saveAnswers(@RequestBody ArrayList<AnswerFromUser> answers) {
        Student student = studentRepository.findByUsername(answers.get(0).getStudentName());
        for (AnswerFromUser answer : answers) {
            Answer answerForDb = new Answer(student, answer.getPickedAnswer(), answer.getPickedAnswer().getQuestion().getTest());
            answerRepository.save(answerForDb);
        }
    }
}
