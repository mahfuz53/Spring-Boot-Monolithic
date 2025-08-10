package com.mahfuz.monolithic.quiz.controller;

import com.mahfuz.monolithic.quiz.model.Question;
import com.mahfuz.monolithic.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question-domain")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("question")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("question/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("question")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return  questionService.addQuestion(question);
    }

    @PutMapping("/question/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Question question) {
        return  questionService.updateQuestion(id, question);
    }

    @DeleteMapping("/question/{questionId}")
    public ResponseEntity<String> deleteQuestion(@PathVariable("questionId") int id){
        return questionService.deleteQuestion(id);
    }

}
