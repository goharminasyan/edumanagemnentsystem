package com.epam.edumanagementsystem.teacher.rest.api;

import com.epam.edumanagementsystem.admin.rest.service.AcademicClassService;
import com.epam.edumanagementsystem.admin.rest.service.AcademicCourseService;
import com.epam.edumanagementsystem.admin.rest.service.SubjectService;
import com.epam.edumanagementsystem.parent.model.dto.ParentDto;
import com.epam.edumanagementsystem.teacher.mapper.TeacherMapper;
import com.epam.edumanagementsystem.teacher.model.dto.TeacherDto;
import com.epam.edumanagementsystem.teacher.model.dto.TeacherEditDto;
import com.epam.edumanagementsystem.teacher.model.entity.Teacher;
import com.epam.edumanagementsystem.teacher.rest.service.TeacherService;
import com.epam.edumanagementsystem.util.InputFieldsValidation;
import com.epam.edumanagementsystem.util.UserDataValidation;
import com.epam.edumanagementsystem.util.imageUtil.rest.service.ImageService;
import com.epam.edumanagementsystem.util.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/teachers")
@Tag(name = "Teachers")
public class TeacherController {

    private static final String TEACHER_SECTION_HTML = "teacherSection";
    private static final String TEACHER_PROFILE_HTML = "teacherProfile";
    private static final String REDIRECT_TO_TEACHERS = "redirect:/teachers/";
    private static final String PROFILE_URL = "/profile";
    private static final String CLASSES_FOR_TEACHER_HTML = "classesInTeacherProfile";
    private static final String COURSES_FOR_TEACHER_HTML = "coursesInTeacherProfile";
    private static final String SUBJECTS_FOR_TEACHER_HTML = "subjectSectionForTeacherProfile";

    private final TeacherService teacherService;
    private final AcademicClassService academicClassService;
    private final AcademicCourseService academicCourseService;
    private final ImageService imageService;
    private final SubjectService subjectService;


    public TeacherController(TeacherService teacherService, AcademicClassService academicClassService,
                             AcademicCourseService academicCourseService, ImageService imageService,
                             SubjectService subjectService) {
        this.teacherService = teacherService;
        this.academicClassService = academicClassService;
        this.academicCourseService = academicCourseService;
        this.imageService = imageService;
        this.subjectService = subjectService;
    }

    @GetMapping
    @Operation(summary = "Gets the list of teachers and shows on admin's dashboard")
    public String openTeacherSection(Model model) {
        model.addAttribute("teachers", teacherService.findAll());
        model.addAttribute("teacher", new TeacherDto());
        return TEACHER_SECTION_HTML;
    }

    @PostMapping
    @Operation(summary = "Creates a new teacher and saves in DB")
    public String saveTeacher(@ModelAttribute("teacher") @Valid TeacherDto teacherDto,
                              BindingResult bindingResult,
                              @RequestParam(value = "picture", required = false) MultipartFile multipartFile,
                              @RequestParam(value = "status", required = false) String status,
                              Model model) throws IOException {

        model.addAttribute("teachers", teacherService.findAll());
        UserDataValidation.checkMultipartFile(multipartFile, status, model);
        teacherService.checkEmailForCreate(teacherDto, bindingResult, model);

        if (bindingResult.hasErrors()) {
            return TEACHER_SECTION_HTML;
        }
        TeacherDto savedTeacherDto = teacherService.save(teacherDto);
        if (!multipartFile.isEmpty()) {
            teacherService.addImage(savedTeacherDto, multipartFile);
        }
        return REDIRECT_TO_TEACHERS;
    }

    @GetMapping("/{id}/profile")
    @Operation(summary = "Shows selected teacher's profile")
    public String openTeacherProfile(@PathVariable("id") Long id, Model model) {
        model.addAttribute("teacher", teacherService.findById(id));
        model.addAttribute("name_surname", teacherService.findById(id).getFullName());
        return TEACHER_PROFILE_HTML;
    }

    @PostMapping("/{id}/profile")
    @Operation(summary = "Edits selected teacher's profile")
    public String editTeacherProfile(@ModelAttribute("teacher") @Valid TeacherEditDto teacherDto,
                                     BindingResult bindingResult, @PathVariable("id") Long id, Model model) {

        teacherService.checkEmailForEdit(teacherDto, bindingResult, id, model);

        if (bindingResult.hasErrors()) {
            model.addAttribute("teacherData", teacherService.findById(id).getFullName());
            return TEACHER_PROFILE_HTML;
        }
        teacherService.update(teacherDto);
        return REDIRECT_TO_TEACHERS + id + PROFILE_URL;
    }

    @PostMapping("/{id}/image/add")
    @Operation(summary = "Adds image to selected teacher's profile")
    public String addImage(@PathVariable("id") Long id, @RequestParam("picture") MultipartFile multipartFile) {
        teacherService.addImage(teacherService.findById(id), multipartFile);
        return REDIRECT_TO_TEACHERS + id + PROFILE_URL;
    }

    @GetMapping("/{id}/image/delete")
    @Operation(summary = "Deletes image from selected teacher's profile")
    public String deleteImage(@PathVariable("id") Long id) {
        imageService.deleteImage(teacherService.findById(id).getPicUrl());
        teacherService.removeImage(id);
        return REDIRECT_TO_TEACHERS + id + PROFILE_URL;
    }

    @GetMapping("/{id}/classes")
    public String openClassesInTeacherProfile(@PathVariable("id") Long id, Model model) {
        model.addAttribute("teacher", teacherService.findById(id));
        model.addAttribute("teachersClasses", academicClassService.findAcademicClassByTeacherId(id));
        return CLASSES_FOR_TEACHER_HTML;
    }

    @GetMapping("/{id}/courses")
    @Operation(summary = "Gets the list of courses thw teacher has and shows them")
    public String openCoursesInTeacherProfile(@PathVariable("id") Long id, Model model) {
        model.addAttribute("teacher", teacherService.findById(id));
        model.addAttribute("teachersCourses", academicCourseService.findAcademicCoursesByTeacherId(id));
        return COURSES_FOR_TEACHER_HTML;
    }

    @GetMapping("/{id}/subjects")
    @Operation(summary = "Gets the list of subjects thw teacher has and shows them")
    public String openSubjectsInTeacherProfile(@PathVariable("id") Long id, Model model) {
        model.addAttribute("subjects", subjectService.findSubjectsByTeacherSetId(id));
        model.addAttribute("teacher", teacherService.findById(id));
        return SUBJECTS_FOR_TEACHER_HTML;
    }
}
