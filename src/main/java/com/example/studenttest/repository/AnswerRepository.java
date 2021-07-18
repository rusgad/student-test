package com.example.studenttest.repository;

import com.example.studenttest.model.Answer;
import com.example.studenttest.model.Question;
import com.example.studenttest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    ArrayList<Answer> findByStudentAndTestId(Student student, long testId);
    Answer findAnswerByStudentAndQuestion(Student student, Question question);
}
