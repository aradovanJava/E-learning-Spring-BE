package hr.algebra.e_learning.utils;

import hr.algebra.e_learning.dto.CourseDTO;
import hr.algebra.e_learning.dto.LectureDTO;
import hr.algebra.e_learning.dto.security.AuthRequestDTO;
import hr.algebra.e_learning.service.CourseService;
import hr.algebra.e_learning.service.LectureService;
import hr.algebra.e_learning.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final CourseService courseService;
    private final StudentService userService;
    private final LectureService lectureService;

    @Override
    public void run(String... args) {
        System.out.println("About to load all courses and users...");

        final CourseDTO spring = new CourseDTO(1L, "Spring Boot course", "Spring");
        final CourseDTO flutter = new CourseDTO(2L, "Flutter course", "Flutter");
        final CourseDTO swiftUI = new CourseDTO(3L, "SwiftUI course", "SwiftUI");

        final LectureDTO introLecture = LectureDTO
                .builder()
                .title("Spring Boot Intro")
                .description("Spring Boot Intro lecture description")
                .courseId(1L)
                .build();

        final LectureDTO dataJpaLecture = LectureDTO
                .builder()
                .title("Spring Data JPA")
                .description("Spring Data JPA lecture description")
                .courseId(1L)
                .build();

        courseService.save(spring);
        courseService.save(flutter);
        courseService.save(swiftUI);

        lectureService.save(introLecture);
        lectureService.save(dataJpaLecture);

        final AuthRequestDTO user = new AuthRequestDTO("admin", "algebra");

        userService.register(user);

        System.out.println("Successfully loaded all data!");
    }
}
