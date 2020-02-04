package fr.tse.quiz.service;

import java.util.List;

import fr.tse.quiz.business.Niveau;
import fr.tse.quiz.business.Question;
import fr.tse.quiz.business.Quiz;
import fr.tse.quiz.business.Reponse;

public interface QuestionService {
	
	Question ajouterQuestion(String intitule, String media, Niveau niveau, String theme, Quiz quiz);
	
	List<Question> recupererQuestions();

	Question recupererQuestion(Long id);
	
	void ajouterReponses(List<Reponse> reponses, Question question);
	
	void supprimerQuestion(Question question);

}
