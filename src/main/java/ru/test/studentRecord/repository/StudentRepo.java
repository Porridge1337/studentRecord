package ru.test.studentRecord.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.studentRecord.model.Student;

public interface StudentRepo extends JpaRepository<Student, String> {
}
