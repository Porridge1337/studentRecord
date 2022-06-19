package ru.test.studentRecord.service;

import ru.test.studentRecord.dto.StudentDto;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Optional<StudentDto> findById(String id);

    List<StudentDto> findAllStudent();

    StudentDto saveStudent(StudentDto student);

    void deleteStudent(String id);


}
