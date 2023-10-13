package hr.algebra.e_learning.dto;

import lombok.Builder;

@Builder
public record LectureDTO(Long id, String title, String description, Long courseId) {
}
