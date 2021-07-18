package com.example.studenttest.rest;

import com.example.studenttest.dto.OptionDto;
import com.example.studenttest.service.OptionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/option")
public class OptionRestController {
    private OptionService optionService;

    public OptionRestController(OptionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping("/{questionId}")
    public ArrayList<OptionDto> getOptions(@PathVariable long questionId) {
        ArrayList<OptionDto> options = optionService.findByQuestionId(questionId);
        return options;
    }
}
