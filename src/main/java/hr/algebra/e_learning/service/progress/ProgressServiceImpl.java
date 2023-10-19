package hr.algebra.e_learning.service.progress;

import hr.algebra.e_learning.dto.progress.ProgressDTO;
import hr.algebra.e_learning.entity.Progress;
import hr.algebra.e_learning.mapper.progress.ProgressEntityToDtoMapper;
import hr.algebra.e_learning.repository.ProgressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProgressServiceImpl implements ProgressService {

    private final ProgressRepository progressRepository;
    private final ProgressEntityToDtoMapper entityToDtoMapper;

    @Override
    public Optional<ProgressDTO> getProgressByCourseIdAndStudentId(final Long courseId, final Long studentId) {
        return progressRepository.findProgressByCourseIdAndStudentId(courseId, studentId).map(entityToDtoMapper::convert);
    }

    @Override
    public Progress createNewProgress(final Progress progress) {
        return progressRepository.save(progress);
    }
}
