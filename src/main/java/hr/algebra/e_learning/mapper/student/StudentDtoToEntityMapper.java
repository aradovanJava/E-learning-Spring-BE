package hr.algebra.e_learning.mapper.student;

import hr.algebra.e_learning.mapper.Mapper;
import hr.algebra.e_learning.dto.StudentDTO;
import hr.algebra.e_learning.entity.Course;
import hr.algebra.e_learning.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDtoToEntityMapper implements Mapper<StudentDTO, Student> {
    @Override
    public Student convert(final StudentDTO dto) {
        final List<Course> courseList = getConvertedCourses(dto);
        return Student.builder()
                .id(dto.id())
                .username(dto.username())
                .courses(courseList)
                .build();
    }

    private List<Course> getConvertedCourses(final StudentDTO studentDTO) {
        return studentDTO.courses().stream().map(
                (courseDTO) -> Course.builder()
                        .id(courseDTO.getId())
                        .title(courseDTO.getTitle())
                        .description(courseDTO.getDescription())
                        .build()
        ).toList();
    }
}
