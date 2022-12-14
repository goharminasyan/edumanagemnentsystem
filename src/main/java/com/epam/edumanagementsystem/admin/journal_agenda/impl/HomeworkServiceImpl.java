package com.epam.edumanagementsystem.admin.journal_agenda.impl;

import com.epam.edumanagementsystem.admin.journal_agenda.model.dto.SaveAgendaDto;
import com.epam.edumanagementsystem.admin.journal_agenda.model.entity.Homework;
import com.epam.edumanagementsystem.admin.journal_agenda.rest.repository.HomeworkRepository;
import com.epam.edumanagementsystem.admin.journal_agenda.rest.service.HomeworkService;
import com.epam.edumanagementsystem.admin.rest.repository.AcademicClassRepository;
import com.epam.edumanagementsystem.admin.rest.repository.AcademicCourseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class HomeworkServiceImpl implements HomeworkService {

    private final HomeworkRepository homeworkRepository;
    private final AcademicClassRepository academicClassRepository;
    private final AcademicCourseRepository academicCourseRepository;

    public HomeworkServiceImpl(HomeworkRepository homeworkRepository, AcademicClassRepository academicClassRepository, AcademicCourseRepository academicCourseRepository) {
        this.homeworkRepository = homeworkRepository;
        this.academicClassRepository = academicClassRepository;
        this.academicCourseRepository = academicCourseRepository;
    }

    @Override
    public Homework save(SaveAgendaDto saveAgendaDto) {
        Homework homework = new Homework();
        homework.setHomework(saveAgendaDto.getHomework());
        homework.setDateOfHomework(LocalDate.parse(saveAgendaDto.getDate()));
        homework.setAcademicClass(academicClassRepository.findById(saveAgendaDto.getClassId()).get());
        homework.setCourseOfHomework(academicCourseRepository.findById(saveAgendaDto.getCourseId()).get());
        return homeworkRepository.save(homework);
    }

}
