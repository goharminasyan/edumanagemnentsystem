package com.epam.edumanagementsystem.admin.model.entity;

import com.epam.edumanagementsystem.admin.timetable.model.entity.CoursesForTimetable;
import com.epam.edumanagementsystem.teacher.model.entity.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "academicClass")
public class AcademicClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50, message = "Symbols can't be more than 50")
    @Column(unique = true)
    @NotBlank(message = "Please, fill the required fields")
    private String classNumber;
    @JsonIgnore

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL})
    @JoinTable(name = "academicClass_teacher_mapping",
            joinColumns = @JoinColumn(name = "academicClass_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private Set<Teacher> teacher;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL})
    @JoinTable(name = "academicClass_academicCourse_mapping",
            joinColumns = @JoinColumn(name = "academicClass_id"),
            inverseJoinColumns = @JoinColumn(name = "academicCourse_id"))
    private Set<AcademicCourse> academicCourseSet;

    @OneToOne
    private Teacher classroomTeacher;

    @ManyToMany
    private List<CoursesForTimetable> coursesForTimetableList = new ArrayList<>();

    public AcademicClass() {
    }

    public AcademicClass(Long id, String classNumber, Set<Teacher> teacher, Set<AcademicCourse> academicCourseSet, List<CoursesForTimetable> coursesForTimetableList) {
        this.id = id;
        this.classNumber = classNumber;
        this.teacher = teacher;
        this.academicCourseSet = academicCourseSet;
        this.classroomTeacher = classroomTeacher;
        this.coursesForTimetableList = coursesForTimetableList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public Set<Teacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(Set<Teacher> teacher) {
        this.teacher = teacher;
    }

    public Set<AcademicCourse> getAcademicCourseSet() {
        return academicCourseSet;
    }

    public void setAcademicCourseSet(Set<AcademicCourse> academicCourseSet) {
        this.academicCourseSet = academicCourseSet;
    }

    public List<CoursesForTimetable> getCoursesForTimetableList() {
        return coursesForTimetableList;
    }

    public void setCoursesForTimetableList(List<CoursesForTimetable> coursesForTimetableList) {
        this.coursesForTimetableList = coursesForTimetableList;
    }

    public Teacher getClassroomTeacher() {
        return classroomTeacher;
    }

    public void setClassroomTeacher(Teacher classroomTeacher) {
        this.classroomTeacher = classroomTeacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcademicClass that = (AcademicClass) o;
        return Objects.equals(id, that.id) && Objects.equals(classNumber, that.classNumber) && Objects.equals(teacher, that.teacher) && Objects.equals(classroomTeacher, that.classroomTeacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, classNumber, teacher,classroomTeacher);
    }

    @Override
    public String toString() {
        return "AcademicClass{" +
                "id=" + id +
                ", classNumber='" + classNumber + '\'' +
                ", teacher=" + teacher +
                ", academicCourseSet=" + academicCourseSet +
                ", coursesForTimetableList=" + coursesForTimetableList +
                '}';
    }
}
