package hr.algebra.e_learning.mapper.course;

import hr.algebra.e_learning.mapper.Mapper;
import hr.algebra.e_learning.dto.CourseDTO;
import hr.algebra.e_learning.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseDtoToEntityMapper implements Mapper<CourseDTO, Course> {
    @Override
    public Course convert(CourseDTO dto) {
        return Course.builder()
                .id(dto.id())
                .title(dto.title())
                .description(dto.description())
                .build();
    }
}
