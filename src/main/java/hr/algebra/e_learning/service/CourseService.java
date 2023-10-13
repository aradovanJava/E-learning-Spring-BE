package hr.algebra.e_learning.service;

import hr.algebra.e_learning.dto.course.CourseDTO;
import hr.algebra.e_learning.dto.course.CreateCourseDTO;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<CourseDTO> getAll();
    Optional<CourseDTO> getById(Long id);
    void save(CreateCourseDTO courseDto);
    void delete(CourseDTO courseDto);
    void deleteById(Long id);
    List<CourseDTO> getAllForStudent(Long id);
}
