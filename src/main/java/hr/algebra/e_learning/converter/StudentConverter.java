package hr.algebra.e_learning.converter;

import hr.algebra.e_learning.dto.StudentDTO;
import hr.algebra.e_learning.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter implements EntityDTOConverter<Student, StudentDTO> {

    @Override
    public StudentDTO toDto(Student entity) {
        return StudentDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .build();
    }

    @Override
    public Student toEntity(StudentDTO dto) {
        return Student.builder()
                .id(dto.id())
                .username(dto.username())
                .build();
    }
}
