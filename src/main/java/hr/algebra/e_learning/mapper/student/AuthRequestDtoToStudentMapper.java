package hr.algebra.e_learning.mapper.student;

import hr.algebra.e_learning.mapper.Mapper;
import hr.algebra.e_learning.dto.security.AuthRequestDTO;
import hr.algebra.e_learning.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class AuthRequestDtoToStudentMapper implements Mapper<AuthRequestDTO, Student> {

    @Override
    public Student convert(final AuthRequestDTO dto) {
        return Student.builder()
                .username(dto.username())
                .password(dto.password())
                .build();
    }
}
