package com.example.studenttest.repository;

import com.example.studenttest.model.Answer;
import com.example.studenttest.model.Question;
import com.example.studenttest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    ArrayList<Answer> findByStudent_UsernameAndTest_Id(String username, long testId);
    Answer findAnswerByStudentAndQuestion(Student student, Question question);
}
