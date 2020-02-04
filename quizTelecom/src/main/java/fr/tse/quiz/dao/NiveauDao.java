package fr.tse.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.tse.quiz.business.Niveau;

public interface NiveauDao extends JpaRepository<Niveau, Long>{

}
