package hr.algebra.e_learning.mapper.question;

import hr.algebra.e_learning.dto.question.QuestionDTO;
import hr.algebra.e_learning.entity.Question;
import hr.algebra.e_learning.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class QuestionDtoToEntityMapper implements Mapper<QuestionDTO, Question> {

    @Override
    public Question convert(final QuestionDTO dto) {
        return Question.builder()
                .id(dto.getId())
                .questionText(dto.getQuestionText())
                .option1(dto.getOption1())
                .option2(dto.getOption2())
                .option3(dto.getOption3())
                .correctOption4(dto.getCorrectOption4())
                .build();
    }
}
