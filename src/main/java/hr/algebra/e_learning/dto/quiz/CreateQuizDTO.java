package hr.algebra.e_learning.dto.quiz;

import hr.algebra.e_learning.dto.question.QuestionDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateQuizDTO {
    private String title;
    private Long lectureId;
    private List<QuestionDTO> questions;
}
