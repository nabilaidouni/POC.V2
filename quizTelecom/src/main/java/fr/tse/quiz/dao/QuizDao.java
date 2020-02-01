package fr.tse.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.tse.quiz.business.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Long>{

}
