package com.example.studenttest.service;

import com.example.studenttest.dto.OptionDto;

import java.util.ArrayList;

public interface OptionService {
    ArrayList<OptionDto> findByQuestionId(long id);
}
