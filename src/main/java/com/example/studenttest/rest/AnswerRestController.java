package com.example.studenttest.rest;

import com.example.studenttest.model.Answer;
import com.example.studenttest.model.Student;
import com.example.studenttest.service.impl.AnswerServiceImpl;
import com.example.studenttest.service.impl.StudentServiceImpl;
import com.example.studenttest.wrappers.AnswerFromUser;
import com.example.studenttest.wrappers.StudentAndTestId;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/answer")
public class AnswerRestController {

    private AnswerServiceImpl answerService;
    private StudentServiceImpl studentService;

    public AnswerRestController(AnswerServiceImpl answerService, StudentServiceImpl studentService) {
        this.answerService = answerService;
        this.studentService = studentService;
    }

    @PostMapping
    public ArrayList<Answer> saveAnswers(@RequestBody ArrayList<AnswerFromUser> selectedAnswers) {
        Student student = studentService.findByUsername(selectedAnswers.get(0).getStudentName());
        ArrayList<Answer> answersForSelectedTest = new ArrayList<>();

        for (AnswerFromUser answer : selectedAnswers) {
            Answer newAnswer = new Answer(student, answer.getPickedAnswer(),
                    answer.getPickedAnswer().getQuestion().getTest(), answer.getPickedAnswer().getQuestion());

            if (answerService.findAnswerByStudentAndQuestion(student, answer.getPickedAnswer()
                    .getQuestion()) == null) {
                answerService.save(newAnswer);
            } else {
                Answer existingAnswer = answerService.findAnswerByStudentAndQuestion
                        (student, answer.getPickedAnswer().getQuestion());
                existingAnswer.setSelectedOption(answer.getPickedAnswer());
                answerService.save(existingAnswer);
            }

            answersForSelectedTest.add(new Answer(student, answer.getPickedAnswer(),
                    answer.getPickedAnswer().getQuestion().getTest(), answer.getPickedAnswer().getQuestion()));
        }

        return answersForSelectedTest;
    }

    @PostMapping("/latest-result")
    public ArrayList<Answer> getLatestResultOfTest(@RequestBody StudentAndTestId studentAndTestId) {
        ArrayList<Answer> latestResultOfTest = answerService.
                findByStudent_UsernameAndTest_Id(studentAndTestId.getUsername(), studentAndTestId.getTestId());
        return latestResultOfTest;
    }
}
