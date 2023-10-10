package hr.algebra.e_learning.converter;

import hr.algebra.e_learning.dto.CourseDTO;
import hr.algebra.e_learning.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseConverter implements EntityDTOConverter<Course, CourseDTO> {
    @Override
    public CourseDTO toDto(Course entity) {
        return new CourseDTO(entity.getId(), entity.getTitle());
    }

    @Override
    public Course toEntity(CourseDTO dto) {
        return new Course(dto.id(), dto.title());
    }
}
