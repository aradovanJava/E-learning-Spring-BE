package hr.algebra.e_learning.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record CourseDTO(Long id, String title, List<StudentDTO> students) {
}
