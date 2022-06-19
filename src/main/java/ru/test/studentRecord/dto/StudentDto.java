package ru.test.studentRecord.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    @NotBlank(message = "Поле имени не должно быть пустым")
    @Size(min = 2, max = 25, message = "поле должно содержать от 2 до 25 символов")
    private String name;
    @Column(name = "surname")
    @NotBlank(message = "Поле фамилии не должно быть пустым")
    @Size(min = 3, max = 25, message = "поле должно содержать от 2 до 25 символов")
    private String surname;
    @Size(max = 25, message = "поле должно содержать не более 25 символов либо быть пустым")
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "date_of_birth")
    @NotNull(message = "поле не должно быть пустым")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    @Column(name = "study_group")
    private String studyGroup;

    public String getIdStr() {
        {
            return String.format("student_%s", id);
        }
    }

}
