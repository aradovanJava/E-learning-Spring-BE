package hr.algebra.e_learning.mapper.student;

import hr.algebra.e_learning.mapper.Mapper;
import hr.algebra.e_learning.dto.security.AuthRequestDTO;
import hr.algebra.e_learning.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentToAuthRequestDtoMapper implements Mapper<Student, AuthRequestDTO> {

    @Override
    public AuthRequestDTO convert(Student entity) {
        return AuthRequestDTO.builder()
                .username(entity.getUsername())
                .password(entity.getPassword())
                .build();
    }
}
