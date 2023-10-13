package hr.algebra.e_learning.service;

import hr.algebra.e_learning.mapper.course.CourseDtoToEntityMapper;
import hr.algebra.e_learning.mapper.course.CourseEntityToDtoMapper;
import hr.algebra.e_learning.dto.CourseDTO;
import hr.algebra.e_learning.entity.Course;
import hr.algebra.e_learning.entity.Student;
import hr.algebra.e_learning.repository.CourseRepository;
import hr.algebra.e_learning.repository.StudentRepository;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final CourseEntityToDtoMapper entityToDtoMapper;
    private final CourseDtoToEntityMapper dtoToEntityMapper;

    @Override
    public List<CourseDTO> getAll() {
        return courseRepository.findAll().stream().map(entityToDtoMapper::convert).toList();
    }

    @Override
    public Optional<CourseDTO> getById(final Long id) {
        return courseRepository.findById(id).map(entityToDtoMapper::convert);
    }

    @Override
    public void save(final CourseDTO courseDto) {
        final Course course = dtoToEntityMapper.convert(courseDto);
        courseRepository.save(course);
    }

    @Override
    public void delete(final CourseDTO courseDto) {
        final Course course = dtoToEntityMapper.convert(courseDto);
        courseRepository.delete(course);
    }

    @Override
    public void deleteById(final Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<CourseDTO> getAllForStudent(Long id) {
        final List<Course> courseList = studentRepository
                .findById(id)
                .map(Student::getCourses)
                .orElseThrow(() -> new NoResultException("No courses found."));
        return courseList.stream().map(entityToDtoMapper::convert).toList();
    }
}
