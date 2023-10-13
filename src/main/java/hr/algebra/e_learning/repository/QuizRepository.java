package hr.algebra.e_learning.repository;

import hr.algebra.e_learning.entity.Quiz;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends ListCrudRepository<Quiz, Long> {
    List<Quiz> findAllByLectureId(Long courseId);
}
