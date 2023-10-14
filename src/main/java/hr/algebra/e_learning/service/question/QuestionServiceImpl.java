package hr.algebra.e_learning.service.question;

import hr.algebra.e_learning.dto.question.QuestionDTO;
import hr.algebra.e_learning.entity.Question;
import hr.algebra.e_learning.entity.Quiz;
import hr.algebra.e_learning.mapper.question.QuestionDtoToEntityMapper;
import hr.algebra.e_learning.mapper.question.QuestionEntityToDtoMapper;
import hr.algebra.e_learning.repository.QuestionRepository;
import hr.algebra.e_learning.repository.QuizRepository;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;

    private final QuestionDtoToEntityMapper questionDtoToEntityMapper;
    private final QuestionEntityToDtoMapper questionEntityToDtoMapper;

    @Override
    public List<QuestionDTO> getAllByQuizId(final Long id) {
        return questionRepository.findAllByQuizId(id).stream().map(questionEntityToDtoMapper::convert).toList();
    }

    @Override
    public Optional<QuestionDTO> getById(final Long id) {
        return questionRepository.findById(id).map(questionEntityToDtoMapper::convert);
    }

    @Override
    public void save(final QuestionDTO questionDTO) {
        final Question newQuestion = questionDtoToEntityMapper.convert(questionDTO);
        final Quiz quiz = quizRepository.findById(questionDTO.getQuizId()).orElseThrow(() -> new NoResultException("No quiz found..."));

        newQuestion.setQuiz(quiz);
        questionRepository.save(newQuestion);
    }

    @Override
    public void delete(final QuestionDTO questionDTO) {
        final Question question = questionDtoToEntityMapper.convert(questionDTO);
        questionRepository.delete(question);
    }

    @Override
    public void deleteById(final Long id) {
        questionRepository.deleteById(id);
    }
}
