package hr.algebra.e_learning.dto;

import lombok.Builder;

@Builder
public record CourseDTO(Long id, String title, String description) {
}
