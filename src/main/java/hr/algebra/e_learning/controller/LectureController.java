package hr.algebra.e_learning.controller;

import hr.algebra.e_learning.dto.LectureDTO;
import hr.algebra.e_learning.service.LectureService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/course/lecture")
public class LectureController {

    private final LectureService lectureService;

    @GetMapping("/{id}/all")
    public ResponseEntity<List<LectureDTO>> getAllForCourse(@PathVariable final Long id) {
        return ResponseEntity.ok(lectureService.getAllForCourse(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LectureDTO> getById(@PathVariable final Long id) {
        return lectureService.getById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public void save(@RequestBody final LectureDTO lectureDTO) {
        lectureService.save(lectureDTO);
    }

    @DeleteMapping("")
    public void delete(@RequestBody final LectureDTO lectureDTO) {
        lectureService.delete(lectureDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable final Long id) {
        lectureService.deleteById(id);
    }
}
