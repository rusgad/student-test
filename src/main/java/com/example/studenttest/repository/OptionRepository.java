package com.example.studenttest.repository;

import com.example.studenttest.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface OptionRepository extends JpaRepository<Option, Long> {
    ArrayList<Option> findByQuestionId(long id);
}
