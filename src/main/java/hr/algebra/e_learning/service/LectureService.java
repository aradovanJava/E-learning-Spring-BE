package hr.algebra.e_learning.service;

import hr.algebra.e_learning.dto.LectureDTO;

import java.util.List;
import java.util.Optional;

public interface LectureService {
    List<LectureDTO> getAllForCourse(Long id);
    Optional<LectureDTO> getById(Long id);
    void save(LectureDTO lectureDTO);
    void delete(LectureDTO lectureDTO);
    void deleteById(Long id);
}
