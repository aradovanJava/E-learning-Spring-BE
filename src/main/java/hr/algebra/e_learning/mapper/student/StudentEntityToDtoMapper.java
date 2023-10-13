package hr.algebra.e_learning.mapper.student;

import hr.algebra.e_learning.mapper.Mapper;
import hr.algebra.e_learning.dto.course.CourseDTO;
import hr.algebra.e_learning.dto.StudentDTO;
import hr.algebra.e_learning.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentEntityToDtoMapper implements Mapper<Student, StudentDTO> {

    @Override
    public StudentDTO convert(Student entity) {
        final List<CourseDTO> courseDtoList = getConvertedCourses(entity);
        return StudentDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .courses(courseDtoList)
                .build();
    }

    private List<CourseDTO> getConvertedCourses(Student entity) {
        return entity.getCourses().stream().map(
                (course) -> CourseDTO.builder()
                        .id(course.getId())
                        .title(course.getTitle())
                        .description(course.getDescription())
                        .build()
        ).toList();
    }
}
