package hr.algebra.e_learning.controller;

import hr.algebra.e_learning.dto.question.QuestionDTO;
import hr.algebra.e_learning.service.question.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/course/lecture/quiz/question")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/{id}/all")
    ResponseEntity<List<QuestionDTO>> getAllForQuiz(@PathVariable final Long id) {
        return ResponseEntity.ok(questionService.getAllByQuizId(id));
    }

    @GetMapping("/{id}")
    ResponseEntity<QuestionDTO> getById(@PathVariable final Long id) {
        return questionService.getById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    void save(@RequestBody final QuestionDTO questionDTO) {
        questionService.save(questionDTO);
    }

    @DeleteMapping("")
    void delete(@RequestBody final QuestionDTO questionDTO) {
        questionService.delete(questionDTO);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable final Long id) {
        questionService.deleteById(id);
    }
}
