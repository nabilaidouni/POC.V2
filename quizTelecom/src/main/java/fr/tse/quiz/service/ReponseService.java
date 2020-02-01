package fr.tse.quiz.service;

import java.util.List;

import fr.tse.quiz.business.Question;
import fr.tse.quiz.business.Reponse;

public interface ReponseService {
	
	Reponse ajouterReponse(String intitule, Boolean isCorrect, Question question);
	
	List<Reponse> recupererReponses();

	Reponse recupererReponse(Long id);
	
	void supprimerReponse(Reponse reponse);

}
