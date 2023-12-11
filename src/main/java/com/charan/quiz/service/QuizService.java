package com.charan.quiz.service;

import com.charan.quiz.dao.QuestionDao;
import com.charan.quiz.dao.QuizDao;
import com.charan.quiz.model.Question;
import com.charan.quiz.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, Integer numQ, String title) {
        List<Question> questions=questionDao.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz= new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.saveAndFlush(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }
}
