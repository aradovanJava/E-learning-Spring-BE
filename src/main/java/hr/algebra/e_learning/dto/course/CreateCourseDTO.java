package hr.algebra.e_learning.dto.course;

import hr.algebra.e_learning.dto.lecture.CreateLectureDTO;
import lombok.Builder;

import java.util.List;

@Builder
public record CreateCourseDTO(String title, String description, List<CreateLectureDTO> lectures) {
}
