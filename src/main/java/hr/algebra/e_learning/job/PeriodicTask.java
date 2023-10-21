package hr.algebra.e_learning.job;

import hr.algebra.e_learning.entity.Course;
import hr.algebra.e_learning.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PeriodicTask {

    private final CourseRepository courseRepository;

    @Scheduled(cron = "0/20 * * * * ?")
    public void checkDatabaseState() {
        final List<Course> courses = courseRepository.findAll();

        System.out.println("Periodic task, num of courses: " + courses.size());
    }

}