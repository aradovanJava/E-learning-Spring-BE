package hr.algebra.e_learning.mapper.course;

import hr.algebra.e_learning.dto.progress.ProgressDTO;
import hr.algebra.e_learning.mapper.Mapper;
import hr.algebra.e_learning.dto.course.CourseDTO;
import hr.algebra.e_learning.entity.Course;
import hr.algebra.e_learning.mapper.progress.ProgressEntityToDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CourseEntityToDtoMapper implements Mapper<Course, CourseDTO> {

    private final ProgressEntityToDtoMapper progressEntityToDtoMapper;

    @Override
    public CourseDTO convert(final Course entity) {
        final ProgressDTO progressDto = progressEntityToDtoMapper.convert(entity.getProgress());
        return CourseDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .progress(progressDto)
                .build();
    }
}
