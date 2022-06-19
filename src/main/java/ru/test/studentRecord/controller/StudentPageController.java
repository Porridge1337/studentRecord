package ru.test.studentRecord.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.test.studentRecord.dto.StudentDto;
import ru.test.studentRecord.service.StudentService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class StudentPageController {

    private final StudentService studentService;

    @GetMapping
    public String getStudentPage(Model model) {
        model.addAttribute("students", studentService.findAllStudent());
        return "index";
    }

    @GetMapping("/create")
    public String getStudentCreatePage(@ModelAttribute(name = "student") StudentDto studentDto) {
        return "actions/createOrUpdate";
    }

    @GetMapping("/update/{id}")
    public String getStudentUpdatePage(@PathVariable String id,
                                       Model model){
        StudentDto studentDto = studentService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Студент не найден"));
        model.addAttribute("student", studentDto);
        return "actions/createOrUpdate";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute(name = "student") StudentDto studentDto, BindingResult br) {
        if (br.hasErrors()) return "actions/createOrUpdate";
        StudentDto studentDto1 = studentService.saveStudent(studentDto);
        System.out.println(studentDto1);
        return "redirect:/";
    }

}
