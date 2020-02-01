package fr.tse.quiz.business;

import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String motDePasse;
	
	private String identifiant;
	
	private Boolean admin;
	
	//private Map<String,Long> scoreAtQuiz;
	
	@OneToMany(mappedBy = "user")
	private List<Quiz> quizs;
	
	public User() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	/*public Map<String, Long> getScoreAtQuiz() {
		return scoreAtQuiz;
	}

	public void setScoreAtQuiz(Map<String, Long> scoreAtQuiz) {
		this.scoreAtQuiz = scoreAtQuiz;
	}*/

	public List<Quiz> getQuizs() {
		return quizs;
	}

	public void setQuizs(List<Quiz> quizs) {
		this.quizs = quizs;
	}
	
}
