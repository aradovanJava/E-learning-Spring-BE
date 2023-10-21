package hr.algebra.e_learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ELearningApplication {
    public static void main(String[] args) {
        SpringApplication.run(ELearningApplication.class, args);
    }
}
