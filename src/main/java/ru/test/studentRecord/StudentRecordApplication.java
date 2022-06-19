package ru.test.studentRecord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.test.studentRecord.dto.StudentDto;
import ru.test.studentRecord.mapper.StudentMapper;
import ru.test.studentRecord.model.Student;
import ru.test.studentRecord.repository.StudentRepo;
import ru.test.studentRecord.service.StudentService;

import java.util.GregorianCalendar;

@SpringBootApplication
public class StudentRecordApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(StudentRecordApplication.class, args);
        /*StudentService service = run.getBean(StudentService.class);
        StudentMapper mapper = run.getBean(StudentMapper.class);

        StudentDto student = new StudentDto();
        student.setName("Sasha");
        student.setSurname("Shpak");
        student.setPatronymic("Dmitrievich");
        student.setDateOfBirth(new GregorianCalendar(2002, 8, 11));
        student.setStudyGroup("p-21");
        service.saveStudent(student);
        System.out.println(service.findById("467f7d92-f98a-4d72-810c-53dcb9fa5de5"));
        System.out.println("---------------------------------------");
        System.out.println(service.findAllStudent());
        service.deleteStudent("467f7d92-f98a-4d72-810c-53dcb9fa5de5");
        System.out.println(service.findById("467f7d92-f98a-4d72-810c-53dcb9fa5de5").orElseThrow());*/

    }

}
