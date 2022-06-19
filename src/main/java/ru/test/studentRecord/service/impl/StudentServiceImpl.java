package ru.test.studentRecord.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.test.studentRecord.dto.StudentDto;
import ru.test.studentRecord.mapper.StudentMapper;
import ru.test.studentRecord.repository.StudentRepo;
import ru.test.studentRecord.service.StudentService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService {

    private final StudentRepo repo;
    private final StudentMapper mapper;

    @Override
    public Optional<StudentDto> findById(String id) {
        return mapper.toOptionalDto(repo.findById(id));
    }

    @Override
    public List<StudentDto> findAllStudent() {
        return mapper.toDtos(repo.findAll());
    }

    @Override
    @Transactional
    public StudentDto saveStudent(StudentDto student) {
        return mapper.toDto(repo.save(mapper.toEntity(student)));
    }

    @Override
    @Transactional
    public void deleteStudent(String id) {
        repo.deleteById(id);
    }
}
