package hr.algebra.e_learning.controller;

import hr.algebra.e_learning.dto.course.CourseDTO;
import hr.algebra.e_learning.dto.course.CreateCourseDTO;
import hr.algebra.e_learning.dto.course.StudentCourseDTO;
import hr.algebra.e_learning.service.course.CourseService;
import hr.algebra.e_learning.service.course.EnrollmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;
    private final EnrollmentService enrollmentService;

    @GetMapping("/all")
    public ResponseEntity<List<CourseDTO>> getAll() {
        return ResponseEntity.ok(courseService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getById(@PathVariable final Long id) {
        return courseService.getById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all/{studentId}")
    public ResponseEntity<List<StudentCourseDTO>> getAllForStudent(@PathVariable final Long studentId) {
        return ResponseEntity.ok(courseService.getAllForStudent(studentId));
    }

    @PostMapping("")
    public void save(@RequestBody final CreateCourseDTO courseDTO) {
        courseService.save(courseDTO);
    }

    @DeleteMapping("")
    public void delete(@RequestBody final CourseDTO courseDTO) {
        courseService.delete(courseDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable final Long id) {
        courseService.deleteById(id);
    }

    @GetMapping("/enroll/{studentId}/{courseId}")
    public void enrollCourse(@PathVariable final Long studentId, @PathVariable final Long courseId) {
        enrollmentService.enrollStudentInTheCourse(studentId, courseId);
    }
}
