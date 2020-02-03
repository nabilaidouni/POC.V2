package fr.tse.quiz.service;

import java.util.List;

import fr.tse.quiz.business.Niveau;

public interface NiveauService {

Niveau ajouterNiveau(String intitule);
	
	List<Niveau> recupererNiveaux();

	Niveau recupererNiveau(Long id);
	
	void supprimerNiveau(Niveau niveau);
}
