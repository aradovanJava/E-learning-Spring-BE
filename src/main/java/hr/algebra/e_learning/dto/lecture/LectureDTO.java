package hr.algebra.e_learning.dto.lecture;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LectureDTO {
    private Long id;
    private String title;
    private String description;
    private Long courseId;
}
