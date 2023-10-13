package hr.algebra.e_learning.service.lecture;

import hr.algebra.e_learning.dto.lecture.CreateLectureDTO;
import hr.algebra.e_learning.dto.lecture.LectureDTO;

import java.util.List;
import java.util.Optional;

public interface LectureService {
    List<LectureDTO> getAllForCourse(Long id);
    Optional<LectureDTO> getById(Long id);
    void save(CreateLectureDTO lectureDTO);
    void delete(LectureDTO lectureDTO);
    void deleteById(Long id);
}
