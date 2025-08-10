package com.mahfuz.monolithic.quiz.service;

import com.mahfuz.monolithic.quiz.dao.QuestionDao;
import com.mahfuz.monolithic.quiz.dao.QuizDao;
import com.mahfuz.monolithic.quiz.model.Question;
import com.mahfuz.monolithic.quiz.model.QuestionWrapper;
import com.mahfuz.monolithic.quiz.model.Quiz;
import com.mahfuz.monolithic.quiz.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        try {
            List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);
            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setQuestions(questions);
            quizDao.save(quiz);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        try {
            Optional<Quiz> quiz = quizDao.findById(id);
            System.out.print(quiz.toString());
            List<Question> questionFromDB = quiz.get().getQuestions();
            List<QuestionWrapper> questionForUser = new ArrayList<>();
            for (Question ques : questionFromDB) {
                QuestionWrapper qW = new QuestionWrapper(ques.getId(), ques.getQuestionTitle(),
                        ques.getOption1(), ques.getOption2(), ques.getOption3(), ques.getOption4());
                questionForUser.add(qW);
            }
            System.out.print(questionForUser.toString());
            return new ResponseEntity<>(questionForUser, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity<Integer> submit(Integer id, List<Response> responses) {

        try {
            Optional<Quiz> quiz = quizDao.findById(id);
            List<Question> questionFromDB = quiz.get().getQuestions();

            int rightAnswer = 0;
            int i = 0;
            for (Response response : responses) {
                if (response.getResponse().equals(questionFromDB.get(i).getRightAnswer())) {
                    rightAnswer++;
                }
                i++;
            }
            return new ResponseEntity<>(rightAnswer, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(0, HttpStatus.BAD_REQUEST);
        }


    }
}
