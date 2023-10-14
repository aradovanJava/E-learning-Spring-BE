package hr.algebra.e_learning.mapper.quiz;

import hr.algebra.e_learning.dto.quiz.CreateQuizDTO;
import hr.algebra.e_learning.entity.Quiz;
import hr.algebra.e_learning.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class CreateQuizDtoToEntityMapper implements Mapper<CreateQuizDTO, Quiz> {

    @Override
    public Quiz convert(final CreateQuizDTO dto) {
        return Quiz.builder()
                .title(dto.getTitle())
                .build();
    }
}
