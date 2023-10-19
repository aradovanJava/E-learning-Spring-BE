package hr.algebra.e_learning.mapper.course;

import hr.algebra.e_learning.dto.course.StudentCourseDTO;
import hr.algebra.e_learning.dto.progress.ProgressDTO;
import hr.algebra.e_learning.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseEntityToStudentCourseDtoMapper {

    public StudentCourseDTO convert(Course entity, ProgressDTO progressDTO) {
        return StudentCourseDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .progress(progressDTO)
                .build();
    }
}
