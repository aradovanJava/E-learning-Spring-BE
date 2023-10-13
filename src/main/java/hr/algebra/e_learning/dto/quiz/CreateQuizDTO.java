package hr.algebra.e_learning.dto.quiz;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateQuizDTO {
    private String title;
    private Long lectureId;
}
