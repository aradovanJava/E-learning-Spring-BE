package hr.algebra.e_learning.dto.lecture;

import hr.algebra.e_learning.dto.quiz.CreateQuizDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateLectureDTO {
    private String title;
    private String description;
    private Long courseId;
    private List<CreateQuizDTO> quizzes;
}
