
package fr.tse.quiz.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tse.quiz.business.Quiz;
import fr.tse.quiz.business.Score;
import fr.tse.quiz.business.User;
import fr.tse.quiz.dao.ScoreDao;
import fr.tse.quiz.dao.UserDao;
import fr.tse.quiz.dao.QuizDao;

import fr.tse.quiz.service.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	private ScoreDao scoreDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private QuizDao quizDao;
	

	@Override
	public Score ajouterScore(int value, Long iduser, Long idquiz) {
		// TODO Auto-generated method stub
		User user = userDao.findOne(0l);
		Quiz quiz = quizDao.findOne(idquiz);
		System.out.println(user.getIdentifiant());
		System.out.println(quiz.getIntitule());
		Score score = new Score(value,quiz ,user );
		scoreDao.save(score);
		return score;
	}

	@Override
	public Score recupererScoresOfUser(Long id) {
		User user = userDao.findOne(id);
		Score scores = scoreDao.findByUser(user);
		return scores;
	}
	
	@Override
	public Score recupererScoreOfUserForQuiz(Long idUser, Long idQuiz) {
			User user = userDao.findOne(idUser);
			Quiz quiz = quizDao.findOne(idQuiz);
			Score score = scoreDao.findByUserAndQuiz(user, quiz);
			return score;
		}
	
	@Override
	public void mettreaJourScore(int value, User user, Quiz quiz) {
		// TODO Auto-generated method stub
		Score score = scoreDao.findByUserAndQuiz(user, quiz);
		score.setValue(value);
		scoreDao.save(score);
		
		
	}
	
	public void incrementScore(User user, Quiz quiz) {
		Score score = scoreDao.findByUserAndQuiz(user, quiz);
		int old_value = score.getValue();
		score.setValue(old_value++);
		scoreDao.save(score);
	}

}


