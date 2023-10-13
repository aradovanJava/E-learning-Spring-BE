package hr.algebra.e_learning.mapper.quiz;

import hr.algebra.e_learning.dto.quiz.QuizDTO;
import hr.algebra.e_learning.entity.Quiz;
import hr.algebra.e_learning.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class QuizEntityToDtoMapper implements Mapper<Quiz, QuizDTO> {

    @Override
    public QuizDTO convert(Quiz entity) {
        return QuizDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .lectureId(entity.getLecture().getId())
                .build();
    }
}
