package hr.algebra.e_learning.repository;

import hr.algebra.e_learning.entity.Question;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends ListCrudRepository<Question, Long> {
    List<Question> findAllByQuizId(Long id);
}
