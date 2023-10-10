package hr.algebra.e_learning.service;

import hr.algebra.e_learning.dto.CourseDTO;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<CourseDTO> getAll();
    Optional<CourseDTO> getById(Long id);
    void save(CourseDTO courseDto);
    void delete(CourseDTO courseDto);
    void deleteById(Long id);
}
