package fr.tse.quiz.service;

import java.util.List;

import fr.tse.quiz.business.Quiz;

public interface QuizService {
	
	Quiz ajouterQuiz();
	
	List<Quiz> recupererQuizs();

	Quiz recupererQuiz(Long id);
	
	void supprimerQuiz(Quiz quiz);

}
