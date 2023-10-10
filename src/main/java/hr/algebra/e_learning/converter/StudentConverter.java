package hr.algebra.e_learning.converter;

import hr.algebra.e_learning.dto.security.AuthRequestDTO;
import hr.algebra.e_learning.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter implements EntityDTOConverter<Student, AuthRequestDTO> {
    @Override
    public AuthRequestDTO toDto(Student entity) {
        return new AuthRequestDTO(entity.getUsername(), entity.getPassword());
    }

    @Override
    public Student toEntity(AuthRequestDTO dto) {
        return Student.builder()
                .username(dto.username())
                .password(dto.password())
                .build();
    }
}
