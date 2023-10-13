package hr.algebra.e_learning.dto.course;

import lombok.Builder;

@Builder
public record CourseDTO(Long id, String title, String description) {
}
