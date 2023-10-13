package hr.algebra.e_learning.service.quiz;

import hr.algebra.e_learning.dto.quiz.CreateQuizDTO;
import hr.algebra.e_learning.dto.quiz.QuizDTO;
import hr.algebra.e_learning.entity.Lecture;
import hr.algebra.e_learning.entity.Quiz;
import hr.algebra.e_learning.mapper.quiz.CreateQuizDtoToEntityMapper;
import hr.algebra.e_learning.mapper.quiz.QuizDtoToEntityMapper;
import hr.algebra.e_learning.mapper.quiz.QuizEntityToDtoMapper;
import hr.algebra.e_learning.repository.LectureRepository;
import hr.algebra.e_learning.repository.QuizRepository;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final LectureRepository lectureRepository;

    private final QuizDtoToEntityMapper quizDtoToEntityMapper;
    private final QuizEntityToDtoMapper quizEntityToDtoMapper;
    private final CreateQuizDtoToEntityMapper createQuizDtoToEntityMapper;

    @Override
    public List<QuizDTO> getAllForLecture(final Long id) {
        return quizRepository.findAllByLectureId(id).stream().map(quizEntityToDtoMapper::convert).toList();
    }

    @Override
    public Optional<QuizDTO> getById(final Long id) {
        return quizRepository.findById(id).map(quizEntityToDtoMapper::convert);
    }

    @Override
    public void save(final CreateQuizDTO quizDTO) {
        final Quiz newQuiz = createQuizDtoToEntityMapper.convert(quizDTO);
        final Lecture lecture = lectureRepository.findById(quizDTO.getLectureId()).orElseThrow(() -> new NoResultException("No lecture found..."));

        newQuiz.setLecture(lecture);
        quizRepository.save(newQuiz);
    }

    @Override
    public void delete(final QuizDTO quizDTO) {
        final Quiz quiz = quizDtoToEntityMapper.convert(quizDTO);
        quizRepository.delete(quiz);
    }

    @Override
    public void deleteById(final Long id) {
        quizRepository.deleteById(id);
    }
}
