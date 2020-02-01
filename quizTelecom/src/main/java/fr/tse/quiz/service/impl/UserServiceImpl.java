package fr.tse.quiz.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tse.quiz.business.Question;
import fr.tse.quiz.business.Quiz;
import fr.tse.quiz.business.Reponse;
import fr.tse.quiz.business.User;
import fr.tse.quiz.dao.ReponseDao;
import fr.tse.quiz.dao.UserDao;
import fr.tse.quiz.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserDao userDAO;
	
	@Override
	public User ajouterUser(String motDePasse, String identifiant, Boolean admin, Map<String,Long> scoreAtQuiz, List<Quiz> quizs) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setMotDePasse(motDePasse);
		user.setIdentifiant(identifiant);
		user.setAdmin(admin);
		user.setScoreAtQuiz(scoreAtQuiz);
		user.setQuizs(quizs);
		return user;
	}

	@Override
	public List<User> recupererUsers() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

	@Override
	public User recupererUser(Long id) {
		// TODO Auto-generated method stub
		return userDAO.findOne(id);
	}
	
	@Override
	public void supprimerUser(User user) {
		
		userDAO.delete(user);
	}

}
