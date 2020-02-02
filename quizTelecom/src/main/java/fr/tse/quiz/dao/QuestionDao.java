package fr.tse.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.tse.quiz.business.Question;

public interface QuestionDao extends JpaRepository<Question, Long>{

}
