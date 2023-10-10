package hr.algebra.e_learning.utils;

import hr.algebra.e_learning.dto.CourseDTO;
import hr.algebra.e_learning.dto.security.AuthRequestDTO;
import hr.algebra.e_learning.service.CourseService;
import hr.algebra.e_learning.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final CourseService courseService;
    private final StudentService userService;

    @Override
    public void run(String... args) {
        System.out.println("About to load all courses and users...");

        final CourseDTO spring = new CourseDTO(1L, "Spring Boot course");
        final CourseDTO flutter = new CourseDTO(2L, "Flutter course");
        final CourseDTO swiftUI = new CourseDTO(3L, "SwiftUI course");

        courseService.save(spring);
        courseService.save(flutter);
        courseService.save(swiftUI);

        final AuthRequestDTO user = new AuthRequestDTO("admin", "algebra");

        userService.register(user);

        System.out.println("Successfully loaded all data!");
    }
}
