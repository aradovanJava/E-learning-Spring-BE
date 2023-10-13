package hr.algebra.e_learning.service.quiz;


import hr.algebra.e_learning.dto.quiz.CreateQuizDTO;
import hr.algebra.e_learning.dto.quiz.QuizDTO;

import java.util.List;
import java.util.Optional;

public interface QuizService {
    List<QuizDTO> getAllForLecture(Long id);
    Optional<QuizDTO> getById(Long id);
    void save(CreateQuizDTO quizDTO);
    void delete(QuizDTO quizDTO);
    void deleteById(Long id);
}
