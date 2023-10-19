package hr.algebra.e_learning.dto.course;

import hr.algebra.e_learning.dto.progress.ProgressDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourseDTO {
    private Long id;
    private String title;
    private String description;
    private ProgressDTO progress;
}
