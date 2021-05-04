package com.example.studenttest.rest;

import com.example.studenttest.model.Option;
import com.example.studenttest.model.QeustionWithOptions;
import com.example.studenttest.model.Question;
import com.example.studenttest.repository.OptionRepository;
import com.example.studenttest.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/question")
public class QuestionRestController {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private OptionRepository optionRepository;

    @GetMapping("/{testId}")
    public ArrayList<QeustionWithOptions> getQuestions(@PathVariable long testId) {
        ArrayList<QeustionWithOptions> qeustionWithOptions = new ArrayList<>();
        ArrayList<Question> questions = (ArrayList<Question>) questionRepository.findByTestId(testId);
        for (Question question : questions) {
            ArrayList<Option> options = (ArrayList<Option>) optionRepository.findByQuestionId(question.getId());
            qeustionWithOptions.add(new QeustionWithOptions(question, options));
        }
        return qeustionWithOptions;
    }
}
