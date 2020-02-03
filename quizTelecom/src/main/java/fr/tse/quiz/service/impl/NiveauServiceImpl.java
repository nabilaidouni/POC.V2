package fr.tse.quiz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tse.quiz.business.Niveau;
import fr.tse.quiz.dao.NiveauDao;
import fr.tse.quiz.service.NiveauService;

@Service
public class NiveauServiceImpl implements NiveauService {

	@Autowired
	private NiveauDao niveauDAO;
	

	@Override
	public Niveau ajouterNiveau(String intitule) {
		// TODO Auto-generated method stub
		Niveau niveau = new Niveau(intitule);
		niveauDAO.save(niveau);
		return niveau;
	}

	@Override
	public List<Niveau> recupererNiveaux() {
		return niveauDAO.findAll();
		
	}

	@Override
	public Niveau recupererNiveau(Long id) {
		// TODO Auto-generated method stub
		return niveauDAO.findOne(id);
	}

	@Override
	public void supprimerNiveau(Niveau niveau) {
		// TODO Auto-generated method stub
		niveauDAO.delete(niveau);
		
	}

}
