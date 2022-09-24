package com.epam.edumanagementsystem.teacher.rest.service;


import com.epam.edumanagementsystem.teacher.model.dto.TeacherDto;
import com.epam.edumanagementsystem.teacher.model.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    void create(TeacherDto teacherDto);

    List<TeacherDto> findAll();

    TeacherDto getTeacherById(Long id);

    Teacher findByUserId(Long id);
}
