package com.epam.edumanagementsystem.admin.journal.model.entity;

import com.epam.edumanagementsystem.admin.model.entity.AcademicClass;
import com.epam.edumanagementsystem.admin.model.entity.AcademicCourse;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "agenda_classwork")
public class Classwork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String classwork;
    private int grade;
    private LocalDate dateOfClasswork;
    @ManyToOne
    private AcademicCourse academicCourse;
    @ManyToOne
    private AcademicClass academicClass;

    public Classwork() {
    }

    public Classwork(Long id, String classwork, int grade, LocalDate dateOfClasswork, AcademicCourse academicCourse, AcademicClass academicClass) {
        this.id = id;
        this.classwork = classwork;
        this.grade = grade;
        this.dateOfClasswork = dateOfClasswork;
        this.academicCourse = academicCourse;
        this.academicClass = academicClass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClasswork() {
        return classwork;
    }

    public void setClasswork(String classwork) {
        this.classwork = classwork;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public LocalDate getDateOfClasswork() {
        return dateOfClasswork;
    }

    public void setDateOfClasswork(LocalDate dateOfClasswork) {
        this.dateOfClasswork = dateOfClasswork;
    }

    public AcademicCourse getAcademicCourse() {
        return academicCourse;
    }

    public void setAcademicCourse(AcademicCourse academicCourse) {
        this.academicCourse = academicCourse;
    }

    public AcademicClass getAcademicClass() {
        return academicClass;
    }

    public void setAcademicClass(AcademicClass academicClass) {
        this.academicClass = academicClass;
    }

    @Override
    public String toString() {
        return "Classwork{" +
                "id=" + id +
                ", classwork='" + classwork + '\'' +
                ", grade=" + grade +
                ", dateOfClasswork=" + dateOfClasswork +
                ", academicCourse=" + academicCourse +
                ", academicClass=" + academicClass +
                '}';
    }
}