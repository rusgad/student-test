package com.example.studenttest.repository;

import com.example.studenttest.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    ArrayList<Question> findAllByTestId(long id);
    Question findById(long id);
}
