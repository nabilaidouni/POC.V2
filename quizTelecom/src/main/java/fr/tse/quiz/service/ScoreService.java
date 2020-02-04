package fr.tse.quiz.service;


import fr.tse.quiz.business.Score;
import fr.tse.quiz.business.User;
import fr.tse.quiz.business.Quiz;

public interface ScoreService {
	
		
		Score ajouterScore(Long value, User user, Quiz quiz);
		
		Score recupererScoresOfUser(Long id);
		
		Score recupererScoreOfUserForQuiz(Long idUser, Long idQuiz);
		
		void mettreaJourScore(Long value, User user, Quiz quiz);
		
		void incrementScore(/*User user, Quiz quiz*/Score score);


}
