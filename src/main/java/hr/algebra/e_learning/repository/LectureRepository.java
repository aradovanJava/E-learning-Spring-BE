package hr.algebra.e_learning.repository;

import hr.algebra.e_learning.entity.Lecture;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends ListCrudRepository<Lecture, Long> {
    List<Lecture> findAllByCourseId(Long courseId);
}
