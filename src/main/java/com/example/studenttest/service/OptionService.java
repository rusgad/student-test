package com.example.studenttest.service;

import com.example.studenttest.dto.OptionDto;
import com.example.studenttest.model.Option;

import java.util.ArrayList;

public interface OptionService {
    ArrayList<OptionDto> findByQuestionId(long id);
}
