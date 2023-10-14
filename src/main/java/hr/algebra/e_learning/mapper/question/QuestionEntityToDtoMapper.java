package hr.algebra.e_learning.mapper.question;

import hr.algebra.e_learning.dto.question.QuestionDTO;
import hr.algebra.e_learning.entity.Question;
import hr.algebra.e_learning.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class QuestionEntityToDtoMapper implements Mapper<Question, QuestionDTO> {

    @Override
    public QuestionDTO convert(final Question entity) {
        return QuestionDTO.builder()
                .id(entity.getId())
                .questionText(entity.getQuestionText())
                .option1(entity.getOption1())
                .option2(entity.getOption2())
                .option3(entity.getOption3())
                .correctOption4(entity.getCorrectOption4())
                .quizId(entity.getId())
                .build();
    }
}
