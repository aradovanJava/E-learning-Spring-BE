package hr.algebra.e_learning.converter;

import hr.algebra.e_learning.dto.CourseDTO;
import hr.algebra.e_learning.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseConverter implements EntityDTOConverter<Course, CourseDTO> {
    @Override
    public CourseDTO toDto(Course entity) {
        return CourseDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .build();
    }

    @Override
    public Course toEntity(CourseDTO dto) {
        return Course.builder()
                .id(dto.id())
                .title(dto.title())
                .build();
    }
}
