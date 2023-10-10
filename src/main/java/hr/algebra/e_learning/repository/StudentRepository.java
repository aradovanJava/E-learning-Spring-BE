package hr.algebra.e_learning.repository;

import hr.algebra.e_learning.entity.Student;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends ListCrudRepository<Student, Long> {
    Optional<Student> findStudentByUsername(String username);
    Optional<Student> findStudentByUsernameAndPassword(String username, String password);
}
