package hr.algebra.e_learning.service.progress;

import hr.algebra.e_learning.dto.progress.ProgressDTO;
import hr.algebra.e_learning.entity.Progress;

import java.util.Optional;

public interface ProgressService {
    Optional<ProgressDTO> getProgressByCourseIdAndStudentId(Long courseId, Long studentId);
    Progress createNewProgress(Progress progress);
}
