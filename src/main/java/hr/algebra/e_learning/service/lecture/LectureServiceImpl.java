package hr.algebra.e_learning.service.lecture;

import hr.algebra.e_learning.dto.lecture.CreateLectureDTO;
import hr.algebra.e_learning.dto.lecture.LectureDTO;
import hr.algebra.e_learning.dto.quiz.CreateQuizDTO;
import hr.algebra.e_learning.entity.Course;
import hr.algebra.e_learning.entity.Lecture;
import hr.algebra.e_learning.mapper.lecture.CreateLectureDtoToLectureEntityMapper;
import hr.algebra.e_learning.mapper.lecture.LectureDtoToEntityMapper;
import hr.algebra.e_learning.mapper.lecture.LectureEntityToDtoMapper;
import hr.algebra.e_learning.repository.CourseRepository;
import hr.algebra.e_learning.repository.LectureRepository;
import hr.algebra.e_learning.service.quiz.QuizService;
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

    private final QuizService quizService;

    private final LectureDtoToEntityMapper lectureDtoToEntityMapper;
    private final LectureEntityToDtoMapper lectureEntityToDtoMapper;
    private final CreateLectureDtoToLectureEntityMapper createLectureDtoToLectureEntityMapper;

    @Override
    public List<LectureDTO> getAllForCourse(final Long id) {
        return lectureRepository.findAllByCourseId(id).stream().map(lectureEntityToDtoMapper::convert).toList();
    }

    @Override
    public Optional<LectureDTO> getById(final Long id) {
        return lectureRepository.findById(id).map(lectureEntityToDtoMapper::convert);
    }

    @Override
    public void save(final CreateLectureDTO lectureDTO) {
        final Lecture newLecture = createLectureDtoToLectureEntityMapper.convert(lectureDTO);
        final Course course = courseRepository.findById(lectureDTO.getCourseId()).orElseThrow(() -> new NoResultException("No course found..."));

        newLecture.setCourse(course);
        final Lecture savedLecture = lectureRepository.save(newLecture);

        for (final CreateQuizDTO quizDTO : lectureDTO.getQuizzes()) {
            quizDTO.setLectureId(savedLecture.getId());
            quizService.save(quizDTO);
        }
    }

    @Override
    public void delete(final LectureDTO lectureDTO) {
        final Lecture lecture = lectureDtoToEntityMapper.convert(lectureDTO);
        lectureRepository.delete(lecture);
    }

    @Override
    public void deleteById(final Long id) {
        lectureRepository.deleteById(id);
    }
}
