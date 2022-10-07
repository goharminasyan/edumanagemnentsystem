package com.epam.edumanagementsystem.admin.timetable.rest.service;

import com.epam.edumanagementsystem.admin.model.entity.AcademicClass;
import com.epam.edumanagementsystem.admin.timetable.model.dto.CoursesForTimetableDto;
import com.epam.edumanagementsystem.admin.timetable.model.entity.CoursesForTimetable;

import java.util.List;

public interface CoursesForTimetableService {

    List<CoursesForTimetable> getCoursesForDayAndClassId(String dayOfWeek, List<AcademicClass> academicClasses);

    void create(CoursesForTimetableDto coursesForTimetableDto);

    void renameById(Long id);

    void delete(Long id);

    void deleteById(Long id);
}