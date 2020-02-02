package fr.tse.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.tse.quiz.business.Reponse;

public interface ReponseDao extends JpaRepository<Reponse, Long>{

}
