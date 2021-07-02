package com.example.studenttest.rest;

import com.example.studenttest.model.Answer;
import com.example.studenttest.model.Student;
import com.example.studenttest.service.impl.AnswerServiceImpl;
import com.example.studenttest.service.impl.StudentServiceImpl;
import com.example.studenttest.wrappers.QuestionWithOptions;
import com.example.studenttest.wrappers.StudentWithTestId;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/answer")
public class AnswerRestController {

    private final AnswerServiceImpl answerService;
    private final StudentServiceImpl studentService;

    public AnswerRestController(AnswerServiceImpl answerService, StudentServiceImpl studentService) {
        this.answerService = answerService;
        this.studentService = studentService;
    }

    @PostMapping
    public void saveAnswers(@RequestBody ArrayList<QuestionWithOptions> answersFromStudent) {
        Student student = studentService.findByUsername(answersFromStudent.get(0).getStudentName());

        for (QuestionWithOptions answer : answersFromStudent) {

            if (!answerService.existByStudentAndQuestion(student, answer.getQuestion())) {
                Answer newAnswer = new Answer(
                        student,
                        answer.getPickedAnswer(),
                        answer.getQuestion().getTest(),
                        answer.getQuestion()
                );
                answerService.save(newAnswer);
            } else {
                Answer existingAnswer = answerService.findAnswerByStudentAndQuestion(student, answer.getQuestion());
                existingAnswer.setSelectedOption(answer.getPickedAnswer());
                answerService.save(existingAnswer);
            }
        }
    }

    @PostMapping("/latest-result")
    public ArrayList<Answer> getLatestResultOfTest(@RequestBody StudentWithTestId studentWithTestId) {
        ArrayList<Answer> latestResultOfTest = answerService.
                findByStudent_UsernameAndTest_Id(studentWithTestId.getUsername(), studentWithTestId.getTestId());
        return latestResultOfTest;
    }
}
