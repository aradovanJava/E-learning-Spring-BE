package hr.algebra.e_learning.service;

import hr.algebra.e_learning.entity.Course;
import hr.algebra.e_learning.entity.Student;
import hr.algebra.e_learning.repository.CourseRepository;
import hr.algebra.e_learning.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    @Override
    public void enrollStudentInTheCourse(final Long studentId, final Long courseId) {
        final Course course = courseRepository.findById(courseId).orElseThrow(() -> new EntityNotFoundException("Course not found."));
        final Student student = studentRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Student not found."));

        course.getStudents().add(student);
        student.getCourses().add(course);

        courseRepository.save(course);
        studentRepository.save(student);
    }
}
