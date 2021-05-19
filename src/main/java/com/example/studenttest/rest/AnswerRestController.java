package com.example.studenttest.rest;

import com.example.studenttest.model.Answer;
import com.example.studenttest.wrappers.AnswerFromUser;
import com.example.studenttest.wrappers.StudentWithTest;
import com.example.studenttest.model.Student;
import com.example.studenttest.repository.AnswerRepository;
import com.example.studenttest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/answer")
public class AnswerRestController {
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/selected")
    public ArrayList<Answer> getStudentAnswersForTest(@RequestBody StudentWithTest studentWithTest) {
        Student student = studentRepository.findByUsername(studentWithTest.getStudentName());
        ArrayList<Answer> studentAnswersForTest =
                answerRepository.findByStudentAndTest_Id(student, studentWithTest.getTestId());
        return studentAnswersForTest;
    }

    @PostMapping
    public void saveAnswers(@RequestBody ArrayList<AnswerFromUser> answers) {
        Student student = studentRepository.findByUsername(answers.get(0).getStudentName());
        for (AnswerFromUser answer : answers) {
            Answer answerForDb = new Answer(student, answer.getPickedAnswer(),
                    answer.getPickedAnswer().getQuestion().getTest());
            answerRepository.save(answerForDb);
        }
    }
}
