package fr.tse.quiz.service;

import java.util.List;

import fr.tse.quiz.business.Reponse;

public interface ReponseService {
	
	Reponse ajouterReponse();
	
	List<Reponse> recupererReponses();

	Reponse recupererReponse(Long id);
	
	void supprimerReponse(Reponse reponse);

}
