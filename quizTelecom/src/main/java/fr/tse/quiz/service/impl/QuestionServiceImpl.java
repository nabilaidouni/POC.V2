package fr.tse.quiz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tse.quiz.business.Niveau;
import fr.tse.quiz.business.Question;
import fr.tse.quiz.business.Quiz;
import fr.tse.quiz.business.Reponse;
import fr.tse.quiz.dao.QuestionDao;
import fr.tse.quiz.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDao questionDAO;
	
	@Override
	public Question ajouterQuestion(String intitule, String media, Niveau niveau, String theme, Quiz quiz) {
		// TODO Auto-generated method stub
		Question question = new Question();
		question.setIntitule(intitule);
		question.setMedia(media);
		question.setNiveau(niveau);
		question.setTheme(theme);
		question.setQuiz(quiz);
		return questionDAO.save(question);
	}

	@Override
	public List<Question> recupererQuestions() {
		// TODO Auto-generated method stub
		return questionDAO.findAll();
	}

	@Override
	public Question recupererQuestion(Long id) {
		// TODO Auto-generated method stub
		return questionDAO.findOne(id);
	}
	
	@Override
	public void supprimerQuestion(Question question) {
		questionDAO.delete(question);
	}
	
	@Override
	public void ajouterReponses(List<Reponse> reponses, Question question) {
		question.setReponses(reponses);
		questionDAO.save(question);
	}

}
