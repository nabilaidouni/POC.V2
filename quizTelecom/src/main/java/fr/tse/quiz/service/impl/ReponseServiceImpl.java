package fr.tse.quiz.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tse.quiz.business.Question;
import fr.tse.quiz.business.Quiz;
import fr.tse.quiz.business.Reponse;
import fr.tse.quiz.dao.ReponseDao;
import fr.tse.quiz.service.ReponseService;

@Service
public class ReponseServiceImpl implements ReponseService{

	
	@Autowired
	private ReponseDao reponseDAO;
	
	@Override
	public Reponse ajouterReponse(String intitule, Boolean isCorrect, Question question) {
		// TODO Auto-generated method stub
		Reponse reponse = new Reponse();
		reponse.setIntitule(intitule);
		reponse.setIsCorrect(isCorrect);
		reponse.setQuestion(question);
		return reponse;
	}

	@Override
	public List<Reponse> recupererReponses() {
		// TODO Auto-generated method stub
		return reponseDAO.findAll();
	}

	@Override
	public Reponse recupererReponse(Long id) {
		// TODO Auto-generated method stub
		return reponseDAO.findOne(id);
	}
	
	@Override
	public void supprimerReponse(Reponse reponse) {
		
		reponseDAO.delete(reponse);
	}

}
