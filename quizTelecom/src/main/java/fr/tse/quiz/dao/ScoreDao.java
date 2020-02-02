package fr.tse.quiz.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import fr.tse.quiz.business.Score;
import fr.tse.quiz.business.User;
import fr.tse.quiz.business.Quiz;

public interface ScoreDao  extends JpaRepository<Score, Long> {

	Score findByUser(User user);
	Score findByUserAndQuiz(User user, Quiz quiz);
}
