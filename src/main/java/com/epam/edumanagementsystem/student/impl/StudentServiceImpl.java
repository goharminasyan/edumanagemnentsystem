package com.epam.edumanagementsystem.student.impl;

import com.epam.edumanagementsystem.student.mapper.StudentMapper;
import com.epam.edumanagementsystem.student.model.dto.StudentDto;
import com.epam.edumanagementsystem.student.model.entity.Student;
import com.epam.edumanagementsystem.student.rest.repository.StudentRepository;
import com.epam.edumanagementsystem.student.rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> findAll() {
        return StudentMapper.toStudentDtoList(studentRepository.findAll());
    }

    @Override
    public StudentDto getById(Long id) {
        return StudentMapper.toStudentDto(studentRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public String delete(StudentDto studentDto) {
        studentRepository.deleteById(studentDto.getId());
        return studentDto.getNameAndSurname() + " is Deleted";
    }

    @Override
    public StudentDto updateField(StudentDto studentDto) {
        Student student = studentRepository.findById(studentDto.getId()).orElseThrow(RuntimeException::new);
        if (studentDto.getName() != null) {
            student.setName(studentDto.getName());
        }
        if (studentDto.getSurname() != null) {
            student.setSurname(studentDto.getSurname());
        }
        if (studentDto.getEmail() != null) {
            student.setEmail(studentDto.getEmail());
        }
        if (studentDto.getPassword() != null) {
            student.setPassword(studentDto.getPassword());
        }
        if (studentDto.getAddress() != null) {
            student.setAddress(studentDto.getAddress());
        }
        if (studentDto.getDate() != null) {
            student.setDate(studentDto.getDate());
        }
        if (studentDto.getBloodGroup() != null) {
            student.setBloodGroup(studentDto.getBloodGroup());
        }
        if (studentDto.getParent() != null) {
            student.setParent(studentDto.getParent());
        }
        if (studentDto.getGender() != null) {
            student.setGender(studentDto.getGender());
        }
        if (studentDto.getAcademicClass() != null) {
            student.setAcademicClass(studentDto.getAcademicClass());
        }
        return StudentMapper.toStudentDto(studentRepository.save(student));
    }

    @Override
    public StudentDto update(StudentDto studentDto) {
        Student student = studentRepository.findById(studentDto.getId()).orElseThrow(RuntimeException::new);
        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        student.setEmail(studentDto.getEmail());
        student.setPassword(studentDto.getPassword());
        student.setAddress(studentDto.getAddress());
        student.setDate(studentDto.getDate());
        student.setBloodGroup(studentDto.getBloodGroup());
        student.setParent(studentDto.getParent());
        student.setGender(studentDto.getGender());
        student.setAcademicClass(studentDto.getAcademicClass());
        return StudentMapper.toStudentDto(studentRepository.save(student));
    }
    @Override
    public Optional<Student> findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }
}
