package com.mahfuz.monolithic.quiz.controller;

import com.mahfuz.monolithic.quiz.model.QuestionWrapper;
import com.mahfuz.monolithic.quiz.model.Response;
import com.mahfuz.monolithic.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz-domain")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("quizCreate")
    public ResponseEntity<String> createQuiz(@RequestParam String category,
                                             @RequestParam int numOfQuestion,
                                             @RequestParam String title) {
        return quizService.createQuiz(category, numOfQuestion, title);
    }


    @GetMapping("getQuiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.submit(id, responses);
    }

}
