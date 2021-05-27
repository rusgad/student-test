package com.example.studenttest.repository;

import com.example.studenttest.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
    ArrayList<Option> findByQuestionId(long id);
}
