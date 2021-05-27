package com.example.studenttest.service.impl;

import com.example.studenttest.model.Option;
import com.example.studenttest.repository.OptionRepository;
import com.example.studenttest.service.OptionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OptionServiceImpl implements OptionService {
    private OptionRepository optionRepository;

    public OptionServiceImpl(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    @Override
    public ArrayList<Option> findByQuestionId(long id) {
        return optionRepository.findByQuestionId(id);
    }
}
