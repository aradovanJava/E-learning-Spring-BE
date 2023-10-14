package hr.algebra.e_learning.utils;

import hr.algebra.e_learning.dto.course.CreateCourseDTO;
import hr.algebra.e_learning.dto.lecture.CreateLectureDTO;
import hr.algebra.e_learning.dto.question.QuestionDTO;
import hr.algebra.e_learning.dto.quiz.CreateQuizDTO;
import hr.algebra.e_learning.dto.security.AuthRequestDTO;
import hr.algebra.e_learning.service.course.CourseService;
import hr.algebra.e_learning.service.student.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final CourseService courseService;
    private final StudentService userService;

    @Override
    public void run(String... args) {
        System.out.println("About to load all courses and users...");

        final QuestionDTO firstQuestion = QuestionDTO
                .builder()
                .questionText("What is the best course in this semester?")
                .option1("Spring")
                .option2("Or Spring")
                .option3("Or maybe Spring")
                .correctOption4("Definitely Spring")
                .quizId(1L)
                .build();

        final QuestionDTO secondQuestion = QuestionDTO
                .builder()
                .questionText("Will I pass this course?")
                .option1("No")
                .option2("Maybe")
                .option3("Yes")
                .correctOption4("Oh yes!")
                .quizId(2L)
                .build();

        final CreateQuizDTO quizIntro = CreateQuizDTO
                .builder()
                .title("Quiz Intro #1")
                .lectureId(1L)
                .questions(List.of(firstQuestion))
                .build();

        final CreateQuizDTO quizJpa = CreateQuizDTO
                .builder()
                .title("Quiz JPA #1")
                .lectureId(2L)
                .questions(List.of(secondQuestion))
                .build();

        final CreateLectureDTO introLecture = CreateLectureDTO
                .builder()
                .title("Spring Boot Intro")
                .description("Spring Boot Intro lecture description")
                .courseId(1L)
                .quizzes(List.of(quizIntro))
                .build();

        final CreateLectureDTO dataJpaLecture = CreateLectureDTO
                .builder()
                .title("Spring Data JPA")
                .description("Spring Data JPA lecture description")
                .courseId(1L)
                .quizzes(List.of(quizJpa))
                .build();

        final CreateLectureDTO flutterIntro = CreateLectureDTO
                .builder()
                .title("Flutter intro")
                .description("In Flutter, everything is a widget")
                .courseId(2L)
                .build();

        final CreateLectureDTO swiftUIIntro = CreateLectureDTO
                .builder()
                .title("SwiftUI intro")
                .description("From Apple Watch to Apple Vision Pro.")
                .courseId(3L)
                .build();

        final CreateCourseDTO spring = CreateCourseDTO.builder()
                .title("Spring Boot course")
                .description("Learn how to create REST API on a clean and easy way.")
                .lectures(List.of(introLecture, dataJpaLecture))
                .build();

/*        final CreateCourseDTO flutter = CreateCourseDTO.builder()
                .title("Flutter course")
                .description("Find out why everyone is falling in love with this framework.")
                .lectures(List.of(flutterIntro))
                .build();

        final CreateCourseDTO swiftUI = CreateCourseDTO.builder()
                .title("SwiftUI course")
                .description("Created by Apple. It says everything. ;)")
                .lectures(List.of(swiftUIIntro))
                .build();*/

        courseService.save(spring);
/*        courseService.save(flutter);
        courseService.save(swiftUI);*/

        final AuthRequestDTO user = new AuthRequestDTO("admin", "algebra");

        userService.register(user);

        System.out.println("Successfully loaded all data!");
    }
}
