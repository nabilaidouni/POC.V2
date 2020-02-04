package fr.tse.quiz.service;

import java.util.List;
import java.util.Map;

import fr.tse.quiz.business.Quiz;
import fr.tse.quiz.business.User;

public interface UserService {
	
	User ajouterUser(String motDePasse, String identifiant, Boolean admin, Map<String,Long> scoreAtQuiz, List<Quiz> quizs);
	
	List<User> recupererUsers();

	User recupererUser(Long id);
	
	User recupererUser(String id);
	
	void supprimerUser(User user);

}
