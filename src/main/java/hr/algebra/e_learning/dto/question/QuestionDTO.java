package hr.algebra.e_learning.dto.question;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionDTO {
    private Long id;

    private String questionText;

    private String option1;

    private String option2;

    private String option3;

    private String correctOption4;

    private Long quizId;
}
