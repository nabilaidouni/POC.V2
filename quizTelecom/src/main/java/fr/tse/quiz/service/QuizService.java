package fr.tse.quiz.service;

import java.util.List;

import fr.tse.quiz.business.Question;
import fr.tse.quiz.business.Quiz;
import fr.tse.quiz.business.Reponse;
import fr.tse.quiz.business.User;

public interface QuizService {
	
	Quiz ajouterQuiz(String intitule, User user, List<Question> questions);
	
	List<Quiz> recupererQuizs();

	Quiz recupererQuiz(Long id);
	
	void supprimerQuiz(Quiz quiz);

	//Quiz ajouterQuiz(String intitule);

}
