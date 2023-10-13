package hr.algebra.e_learning.controller;

import hr.algebra.e_learning.dto.quiz.CreateQuizDTO;
import hr.algebra.e_learning.dto.quiz.QuizDTO;
import hr.algebra.e_learning.service.quiz.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/course/lecture/quiz")
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/{id}/all")
    public ResponseEntity<List<QuizDTO>> getAllForLecture(@PathVariable final Long id) {
        return ResponseEntity.ok(quizService.getAllForLecture(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizDTO> getById(@PathVariable final Long id) {
        return quizService.getById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public void save(@RequestBody final CreateQuizDTO quizDTO) {
        quizService.save(quizDTO);
    }

    @DeleteMapping("")
    public void delete(@RequestBody final QuizDTO quizDTO) {
        quizService.delete(quizDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable final Long id) {
        quizService.deleteById(id);
    }
}
