package hr.algebra.e_learning.mapper.course;

import hr.algebra.e_learning.mapper.Mapper;
import hr.algebra.e_learning.dto.CourseDTO;
import hr.algebra.e_learning.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseEntityToDtoMapper implements Mapper<Course, CourseDTO> {
    @Override
    public CourseDTO convert(Course entity) {
        return CourseDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .build();
    }
}
