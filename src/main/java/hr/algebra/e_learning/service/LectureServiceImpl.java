package hr.algebra.e_learning.service;

import hr.algebra.e_learning.dto.LectureDTO;
import hr.algebra.e_learning.entity.Course;
import hr.algebra.e_learning.entity.Lecture;
import hr.algebra.e_learning.mapper.lecture.LectureDtoToEntityMapper;
import hr.algebra.e_learning.mapper.lecture.LectureEntityToDtoMapper;
import hr.algebra.e_learning.repository.CourseRepository;
import hr.algebra.e_learning.repository.LectureRepository;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LectureServiceImpl implements LectureService{

    private final LectureRepository lectureRepository;
    private final CourseRepository courseRepository;
    private final LectureDtoToEntityMapper dtoToEntityMapper;
    private final LectureEntityToDtoMapper entityToDtoMapper;

    @Override
    public List<LectureDTO> getAllForCourse(final Long id) {
        return lectureRepository.findAllByCourseId(id).stream().map(entityToDtoMapper::convert).toList();
    }

    @Override
    public Optional<LectureDTO> getById(final Long id) {
        return lectureRepository.findById(id).map(entityToDtoMapper::convert);
    }

    @Override
    public void save(final LectureDTO lectureDTO) {
        final Lecture newLecture = dtoToEntityMapper.convert(lectureDTO);
        final Course course = courseRepository.findById(lectureDTO.courseId()).orElseThrow(() -> new NoResultException("No course found..."));

        newLecture.setCourse(course);
        lectureRepository.save(newLecture);
    }

    @Override
    public void delete(final LectureDTO lectureDTO) {
        final Lecture lecture = dtoToEntityMapper.convert(lectureDTO);
        lectureRepository.delete(lecture);
    }

    @Override
    public void deleteById(final Long id) {
        lectureRepository.deleteById(id);
    }
}
