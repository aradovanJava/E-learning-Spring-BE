package hr.algebra.e_learning.mapper.progress;

import hr.algebra.e_learning.dto.progress.ProgressDTO;
import hr.algebra.e_learning.entity.Progress;
import hr.algebra.e_learning.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ProgressEntityToDtoMapper implements Mapper<Progress, ProgressDTO> {

    @Override
    public ProgressDTO convert(final Progress entity) {
        return ProgressDTO.builder()
                .id(entity.getId())
                .courseId(entity.getCourse().getId())
                .studentId(entity.getStudent().getId())
                .percentage(entity.getProgressPercentage())
                .build();
    }
}
