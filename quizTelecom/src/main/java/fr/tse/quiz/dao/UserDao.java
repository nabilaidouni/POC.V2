package fr.tse.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.tse.quiz.business.User;

public interface UserDao extends JpaRepository<User, Long>{

}