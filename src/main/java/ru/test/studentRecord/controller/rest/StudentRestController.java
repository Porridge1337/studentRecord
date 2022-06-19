package ru.test.studentRecord.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.studentRecord.service.StudentService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentRestController {

    private final StudentService studentService;

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> deleteCategory(@PathVariable("id") String id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok(true);
    }

}
