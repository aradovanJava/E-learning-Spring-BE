package hr.algebra.e_learning.service;

import hr.algebra.e_learning.dto.course.CourseDTO;
import hr.algebra.e_learning.dto.course.CreateCourseDTO;
import hr.algebra.e_learning.dto.lecture.CreateLectureDTO;
import hr.algebra.e_learning.entity.Course;
import hr.algebra.e_learning.entity.Student;
import hr.algebra.e_learning.mapper.course.CourseDtoToEntityMapper;
import hr.algebra.e_learning.mapper.course.CourseEntityToDtoMapper;
import hr.algebra.e_learning.mapper.course.CreateCourseDtoToCourseEntityMapper;
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
    private final LectureService lectureService;

    private final CourseEntityToDtoMapper courseEntityToDtoMapper;
    private final CourseDtoToEntityMapper courseDtoToEntityMapper;
    private final CreateCourseDtoToCourseEntityMapper createCourseDtoToCourseEntityMapper;

    @Override
    public List<CourseDTO> getAll() {
        return courseRepository.findAll().stream().map(courseEntityToDtoMapper::convert).toList();
    }

    @Override
    public Optional<CourseDTO> getById(final Long id) {
        return courseRepository.findById(id).map(courseEntityToDtoMapper::convert);
    }

    @Override
    public void save(final CreateCourseDTO courseDto) {
        final Course courseToSave = createCourseDtoToCourseEntityMapper.convert(courseDto);
        final Course savedCourse = courseRepository.save(courseToSave);

        for (final CreateLectureDTO lectureDTO : courseDto.lectures()) {
            lectureDTO.setCourseId(savedCourse.getId());
            lectureService.save(lectureDTO);
        }
    }

    @Override
    public void delete(final CourseDTO courseDto) {
        final Course course = courseDtoToEntityMapper.convert(courseDto);
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
        return courseList.stream().map(courseEntityToDtoMapper::convert).toList();
    }
}
