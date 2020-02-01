package fr.tse.quiz.service;

import java.util.List;

import fr.tse.quiz.business.Question;

public interface QuestionService {
	
	Question ajouterQuestion();
	
	List<Question> recupererQuestions();

	Question recupererQuestion(Long id);
	
	void supprimerQuestion(Question question);

}
