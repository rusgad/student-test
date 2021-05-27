package com.example.studenttest.service;

import com.example.studenttest.model.Option;

import java.util.ArrayList;

public interface OptionService {
    ArrayList<Option> findByQuestionId(long id);
}
