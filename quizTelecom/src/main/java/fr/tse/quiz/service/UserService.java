package fr.tse.quiz.service;

import java.util.List;
import java.util.Map;

import fr.tse.quiz.business.Quiz;
import fr.tse.quiz.business.User;

public interface UserService {
	
	User ajouterUser(String motDePasse, String identifiant, Boolean admin);
	
	void ajouterQuiz(User user, Quiz quiz);
	
	List<User> recupererUsers();

	User recupererUser(Long id);
	
	void supprimerUser(User user);

}
