package hr.algebra.e_learning.repository;

import hr.algebra.e_learning.entity.Progress;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProgressRepository extends ListCrudRepository<Progress, Long> {
    Optional<Progress> findProgressByCourseIdAndStudentId(Long courseId, Long studentId);
}
