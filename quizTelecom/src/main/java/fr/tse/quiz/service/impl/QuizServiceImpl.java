package fr.tse.quiz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tse.quiz.business.Quiz;
import fr.tse.quiz.dao.QuizDao;
import fr.tse.quiz.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizDao quizDAO;
	
	@Override
	public Quiz ajouterQuiz() {
		// TODO Auto-generated method stub
		Quiz quiz = new Quiz();
		return quiz;
	}

	@Override
	public void supprimerQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		quizDAO.delete(quiz);
		
	}

	@Override
	public List<Quiz> recupererQuizs() {
		// TODO Auto-generated method stub
		return quizDAO.findAll();
	}

	@Override
	public Quiz recupererQuiz(Long id) {
		// TODO Auto-generated method stub
		return quizDAO.findOne(id);
	}

}
