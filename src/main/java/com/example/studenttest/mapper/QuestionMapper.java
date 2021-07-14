package com.example.studenttest.mapper;

import com.example.studenttest.dto.QuestionDto;
import com.example.studenttest.model.Question;
import org.mapstruct.Mapper;

@Mapper
public interface QuestionMapper {
    QuestionDto toDto(Question question);
    Question toEntity(QuestionDto questionDto);
}