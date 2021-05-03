package com.example.studenttest.repository;

import com.example.studenttest.model.Question;
import com.example.studenttest.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    ArrayList<Question> findByTestId(long id);
}
