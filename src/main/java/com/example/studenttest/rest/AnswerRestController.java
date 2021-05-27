package com.example.studenttest.rest;

import com.example.studenttest.model.Answer;
import com.example.studenttest.model.Student;
import com.example.studenttest.repository.AnswerRepository;
import com.example.studenttest.repository.StudentRepository;
import com.example.studenttest.wrappers.AnswerFromUser;
import com.example.studenttest.wrappers.StudentAndTestId;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/answer")
public class AnswerRestController {

    private AnswerRepository answerRepository;
    private StudentRepository studentRepository;

    public AnswerRestController(AnswerRepository answerRepository, StudentRepository studentRepository) {
        this.answerRepository = answerRepository;
        this.studentRepository = studentRepository;
    }

    @PostMapping
    public ArrayList<Answer> saveAnswers(@RequestBody ArrayList<AnswerFromUser> selectedAnswers) {
        Student student = studentRepository.findByUsername(selectedAnswers.get(0).getStudentName());
        ArrayList<Answer> answersForSelectedTest = new ArrayList<>();

        for (AnswerFromUser answer : selectedAnswers) {
            Answer newAnswer = new Answer(student, answer.getPickedAnswer(),
                    answer.getPickedAnswer().getQuestion().getTest(), answer.getPickedAnswer().getQuestion());

            if (answerRepository.findAnswerByStudentAndQuestion(student, answer.getPickedAnswer()
                    .getQuestion()) == null) {
                answerRepository.save(newAnswer);
            } else {
                Answer existingAnswer = answerRepository.findAnswerByStudentAndQuestion
                        (student, answer.getPickedAnswer().getQuestion());
                existingAnswer.setSelectedOption(answer.getPickedAnswer());
                answerRepository.save(existingAnswer);
            }

            answersForSelectedTest.add(new Answer(student, answer.getPickedAnswer(),
                    answer.getPickedAnswer().getQuestion().getTest(), answer.getPickedAnswer().getQuestion()));
        }

        return answersForSelectedTest;
    }

    @PostMapping("/latest-result")
    public ArrayList<Answer> getLatestResultOfTest(@RequestBody StudentAndTestId studentAndTestId) {
        ArrayList<Answer> latestResultOfTest = answerRepository.
                findByStudent_UsernameAndTest_Id(studentAndTestId.getUsername(), studentAndTestId.getTestId());
        return latestResultOfTest;
    }
}
