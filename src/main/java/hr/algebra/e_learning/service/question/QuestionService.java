package hr.algebra.e_learning.service.question;

import hr.algebra.e_learning.dto.question.QuestionDTO;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<QuestionDTO> getAllByQuizId(Long id);
    Optional<QuestionDTO> getById(Long id);
    void save(QuestionDTO questionDTO);
    void delete(QuestionDTO questionDTO);
    void deleteById(Long id);
}
