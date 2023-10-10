package hr.algebra.e_learning.service;

import hr.algebra.e_learning.converter.CourseConverter;
import hr.algebra.e_learning.dto.CourseDTO;
import hr.algebra.e_learning.entity.Course;
import hr.algebra.e_learning.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseConverter courseConverter;

    @Override
    public List<CourseDTO> getAll() {
        return courseRepository.findAll().stream().map(courseConverter::toDto).toList();
    }

    @Override
    public Optional<CourseDTO> getById(final Long id) {
        return courseRepository.findById(id).map(courseConverter::toDto);
    }

    @Override
    public void save(final CourseDTO courseDto) {
        final Course course = courseConverter.toEntity(courseDto);
        courseRepository.save(course);
    }

    @Override
    public void delete(final CourseDTO courseDto) {
        final Course course = courseConverter.toEntity(courseDto);
        courseRepository.delete(course);
    }

    @Override
    public void deleteById(final Long id) {
        courseRepository.deleteById(id);
    }
}
