package ru.test.studentRecord.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.test.studentRecord.dto.StudentDto;
import ru.test.studentRecord.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper
public interface StudentMapper {

    @Mappings({
            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "name", source = "entity.name"),
            @Mapping(target = "surname", source = "entity.surname"),
            @Mapping(target = "patronymic", source = "entity.patronymic"),
            @Mapping(target = "dateOfBirth", source = "entity.dateOfBirth"),
            @Mapping(target = "studyGroup", source = "entity.studyGroup")
    })
    StudentDto toDto(Student entity);

    @Mappings({
            @Mapping(target = "id", source = "dto.id"),
            @Mapping(target = "name", source = "dto.name"),
            @Mapping(target = "surname", source = "dto.surname"),
            @Mapping(target = "patronymic", source = "dto.patronymic"),
            @Mapping(target = "dateOfBirth", source = "dto.dateOfBirth"),
            @Mapping(target = "studyGroup", source = "dto.studyGroup")
    })
    Student toEntity(StudentDto dto);

    default Optional<StudentDto> toOptionalDto(Optional<Student> entity) {
        return entity.map(this::toDto);
    }

    default List<StudentDto> toDtos(List<Student> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
