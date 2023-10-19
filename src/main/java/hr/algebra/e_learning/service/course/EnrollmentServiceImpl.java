package hr.algebra.e_learning.service.course;

import hr.algebra.e_learning.entity.Course;
import hr.algebra.e_learning.entity.Progress;
import hr.algebra.e_learning.entity.Student;
import hr.algebra.e_learning.repository.CourseRepository;
import hr.algebra.e_learning.repository.StudentRepository;
import hr.algebra.e_learning.service.progress.ProgressService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final ProgressService progressService;

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    @Override
    public void enrollStudentInTheCourse(final Long studentId, final Long courseId) {
        final Course course = courseRepository.findById(courseId).orElseThrow(() -> new EntityNotFoundException("Course not found."));
        final Student student = studentRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Student not found."));

        final Progress progress = createProgressForEnrolledCourse(course, student);

        course.setProgress(progress);
        course.getStudents().add(student);
        student.getCourses().add(course);

        courseRepository.save(course);
        studentRepository.save(student);
    }

    private Progress createProgressForEnrolledCourse(final Course course, final Student student) {
        final Progress newProgress = Progress
                .builder()
                .course(course)
                .student(student)
                .progressPercentage(0)
                .build();

        return progressService.createNewProgress(newProgress);
    }
}

