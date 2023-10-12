package hr.algebra.e_learning.dto;

import lombok.Builder;

import java.util.List;


@Builder
public record StudentDTO(Long id, String username, List<CourseDTO> courses) {
}
