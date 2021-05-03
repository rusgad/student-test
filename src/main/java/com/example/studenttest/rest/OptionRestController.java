package com.example.studenttest.rest;

import com.example.studenttest.model.Option;
import com.example.studenttest.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/option")
public class OptionRestController {
    @Autowired
    private OptionRepository optionRepository;

    @GetMapping("/{questionId}")
    public ArrayList<Option> getOptions(@PathVariable long questionId) {
        ArrayList<Option> options = optionRepository.findByQuestionId(questionId);
        return options;
    }
}
