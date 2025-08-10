package com.mahfuz.monolithic.quiz.dao;

import com.mahfuz.monolithic.quiz.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
