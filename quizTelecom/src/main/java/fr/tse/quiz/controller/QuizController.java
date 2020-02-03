package fr.tse.quiz.controller;

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

import fr.tse.quiz.business.Quiz;
import fr.tse.quiz.business.Reponse;
import fr.tse.quiz.service.QuestionService;
import fr.tse.quiz.service.QuizService;
import fr.tse.quiz.service.ReponseService;
import fr.tse.quiz.service.UserService;


@Controller
@RequestMapping("/")
public class QuizController {

	private QuizService quizService;
	private QuestionService questionService;
	private ReponseService reponseService;
	private UserService userService;
	
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
	
	@PostConstruct
	public void init() {
		System.out.println("Dans init()");
		
		
	}
}