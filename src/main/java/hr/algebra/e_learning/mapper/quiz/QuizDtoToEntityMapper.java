package hr.algebra.e_learning.mapper.quiz;

import hr.algebra.e_learning.dto.quiz.QuizDTO;
import hr.algebra.e_learning.entity.Quiz;
import hr.algebra.e_learning.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class QuizDtoToEntityMapper implements Mapper<QuizDTO, Quiz> {

    @Override
    public Quiz convert(QuizDTO dto) {
        return Quiz.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .build();
    }
}
