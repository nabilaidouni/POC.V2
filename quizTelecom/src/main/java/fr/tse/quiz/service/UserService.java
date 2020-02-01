package fr.tse.quiz.service;

import java.util.List;

import fr.tse.quiz.business.User;

public interface UserService {
	
	User ajouterUser();
	
	List<User> recupererUsers();

	User recupererUser(Long id);
	
	void supprimerUser(User user);

}
