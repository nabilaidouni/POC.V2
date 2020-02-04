package fr.tse.quiz.service;


import fr.tse.quiz.business.Score;
import fr.tse.quiz.business.User;
import fr.tse.quiz.business.Quiz;

public interface ScoreService {
	
		
		Score ajouterScore(int value, Long iduser, Long idquiz);
		
		Score recupererScoresOfUser(Long id);
		
		Score recupererScoreOfUserForQuiz(Long idUser, Long idQuiz);
		
		void mettreaJourScore(int value, User user, Quiz quiz);
		
		public void incrementScore(User user, Quiz quiz);



}
