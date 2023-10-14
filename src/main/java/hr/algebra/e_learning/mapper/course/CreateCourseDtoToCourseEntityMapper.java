package hr.algebra.e_learning.mapper.course;

import hr.algebra.e_learning.dto.course.CreateCourseDTO;
import hr.algebra.e_learning.entity.Course;
import hr.algebra.e_learning.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class CreateCourseDtoToCourseEntityMapper implements Mapper<CreateCourseDTO, Course> {

    @Override
    public Course convert(final CreateCourseDTO dto) {
        return Course.builder()
                .title(dto.title())
                .description(dto.description())
                .build();
    }
}
