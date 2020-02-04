package fr.tse.quiz.controller;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


import fr.tse.quiz.service.QuestionService;
import fr.tse.quiz.service.QuizService;
import fr.tse.quiz.service.ReponseService;
import fr.tse.quiz.service.UserService;
import fr.tse.quiz.service.ScoreService;


@Controller
@RequestMapping("/")
public class QuizController {

	private QuizService quizService;
	private QuestionService questionService;
	private ReponseService reponseService;
	private UserService userService;
	private ScoreService scoreService;
	
	public QuizController(QuizService quizService, QuestionService questionService, ReponseService reponseService, UserService userService) {
		super();
		this.quizService = quizService;
		this.questionService = questionService;
		this.reponseService = reponseService;
		this.userService = userService;
	}

	@RequestMapping(value = { "index", "/" })
	public ModelAndView accueil() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	 @GetMapping ("result")
	  public ModelAndView getResult( @RequestParam("IDU") Long idUser ) {
	    ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		mav.addObject("user", userService.recupererUser(idUser));
		//mav.addObject("quiz", quizService.recupererQuiz(idQuiz));
		//mav.addObject("score", scoreService.recupererScoreOfUserForQuiz(idUser, idQuiz));
		return mav;
	  }
	 
	@PostConstruct
	public void init() {
		System.out.println("Dans init()");
		if (userService.recupererUsers().isEmpty()) {
			System.out.println("ajout user");
			userService.ajouterUser("123", "lia", false);
			}
		if (quizService.recupererQuizs().isEmpty()) {
			System.out.println("ajout quiz");
			quizService.ajouterQuiz("Mary me", userService.recupererUser(1L));
			
			}
		
		if(questionService.recupererQuestions().isEmpty()) {
			System.out.println("ajout question");
			questionService.ajouterQuestion("What is Carl's favorate food?", null, null, "Mariage", quizService.recupererQuiz(1L));
			
		}
		System.out.println("tout marche");

		reponseService.ajouterReponse("Cake", true, questionService.recupererQuestion(1L));
		reponseService.ajouterReponse("Brownies", false, questionService.recupererQuestion(1L));
		reponseService.ajouterReponse("Pasta", false, questionService.recupererQuestion(1L));
		reponseService.ajouterReponse("Pizza", false, questionService.recupererQuestion(1L));
		
	
		
		}

		
	
	
//	@GetMapping ("questionsJeu/{idQuiz}/{nQuestion}")
//	public ModelAndView playQuiz(
//			@RequestParam(name = "idQuiz") long idQuiz,
//			@RequestParam(name = "nQuestion") int nQuestion) {
//		ModelAndView mav = new ModelAndView();		
//		mav.addObject("quizName", quizService.recupererQuizs().get(0).getIntitule());
//		mav.addObject("question", quizService.recupererQuiz(idQuiz).getQuestions().get(nQuestion).getIntitule());
//		mav.setViewName("questionsJeu");
//		mav.addObject("nmQuestion", nQuestion);
//
//		
//		return mav;
//	}
	
	@GetMapping ("questionsJeu")
	public ModelAndView playQuiz(@RequestParam(name = "idQuiz", defaultValue = "1") Long idQuiz,
			@RequestParam(name = "nQuestion", defaultValue = "0") int nQuestion) {
		ModelAndView mav = new ModelAndView();	
		mav.setViewName("questionsJeu");

		mav.addObject("quiz", quizService.recupererQuiz(1L));
		System.out.println(quizService.recupererQuizs());
		mav.addObject("question", quizService.recupererQuiz(idQuiz).getQuestions().get(nQuestion));
		mav.addObject("reponses", quizService.recupererQuiz(idQuiz).getQuestions().get(nQuestion).getReponses());
		mav.addObject("nQuestion", nQuestion);
		if (nQuestion==0) {
			scoreService.ajouterScore(0, 1L, idQuiz);
		}
		
		return mav;
	}
	
	@PostMapping ("questionSuivante")
	public ModelAndView nextQuestion(
			@RequestParam(name = "reponse0", required = false) Long reponse0,
			@RequestParam(name = "reponse1", required = false) Long reponse1,
			@RequestParam(name = "reponse2", required = false) Long reponse2,
			@RequestParam(name = "reponse3", required = false) Long reponse3,
			@RequestParam(name = "idQuestion") Long idQuestion,
			@RequestParam(name = "nQuestion") int nQuestion,
			@RequestParam(name = "idQuiz") Long idQuiz
			) {
		List<Long> reponses = new ArrayList<Long>();
		if (reponse0 != null) {
			reponses.add(reponse0);
		}
		if (reponse1 != null) {
			reponses.add(reponse1);
		}
		if (reponse2 != null) {
			reponses.add(reponse2);
		}
		if (reponse3 != null) {
			reponses.add(reponse3);
		}
		List<Long> vraiReponses = new ArrayList<Long>();
		questionService.recupererQuestion(idQuestion).getReponses().forEach((resp)->{
			if (resp.getIsCorrect()) {
				vraiReponses.add(resp.getId());
			}
		});
		if (reponses.equals(vraiReponses)) {
			scoreService.incrementScore(userService.recupererUser(1L), quizService.recupererQuiz(idQuiz));
			// TODO incrementer le score 
		}
		System.out.println(scoreService.recupererScoreOfUserForQuiz(1L, idQuiz));
		String redir = "redirect:/questionsJeu?idQuiz=";
		redir = redir.concat(Long.toString(idQuiz));
		redir = redir.concat("&nQuestion=");
		redir = redir.concat(Integer.toString(nQuestion));

		return new ModelAndView(redir) ;
	}
	
	
	

	public void initBinder() {
		
	}
	
}