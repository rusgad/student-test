package com.example.studenttest.service.impl;

import com.example.studenttest.dto.OptionDto;
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
    public ArrayList<OptionDto> findByQuestionId(long id) {
        ArrayList<Option> options = optionRepository.findByQuestionId(id);
        ArrayList<OptionDto> optionDtoList = new ArrayList<>();
        for (Option option : options) {
            OptionDto optionDto = new OptionDto(option.getId(), option.getOptionText(), option.getQuestion());
            optionDtoList.add(optionDto);
        }
        return optionDtoList;
    }
}
