package hr.algebra.e_learning.dto.progress;

import lombok.Builder;

@Builder
public record ProgressDTO(Long id, Long courseId, Long studentId, int percentage) {
}
