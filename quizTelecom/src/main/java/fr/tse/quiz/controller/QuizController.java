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

import fr.tse.quiz.business.Question;
import fr.tse.quiz.business.Quiz;
import fr.tse.quiz.business.Reponse;
import fr.tse.quiz.service.NiveauService;
import fr.tse.quiz.service.QuestionService;
import fr.tse.quiz.service.QuizService;
import fr.tse.quiz.service.ReponseService;
import fr.tse.quiz.service.ScoreService;
import fr.tse.quiz.service.UserService;


@Controller
@RequestMapping("/")
public class QuizController {

	private QuizService quizService;
	private QuestionService questionService;
	private ReponseService reponseService;
	private UserService userService;
	private NiveauService niveauService;
	private ScoreService scoreService;
	
	public QuizController(QuizService quizService, QuestionService questionService, ReponseService reponseService, UserService userService,ScoreService scoreService,NiveauService niveauService) {
		super();
		this.quizService = quizService;
		this.questionService = questionService;
		this.reponseService = reponseService;
		this.userService = userService;
		this.scoreService = scoreService;
		this.niveauService = niveauService;
	}

	@RequestMapping(value = { "index", "/" })
	public ModelAndView accueil() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("users", userService.recupererUsers());
		return mav;
	}
	
	@GetMapping("pageclient")
	public ModelAndView pageClientGet(@RequestParam("IDU") String identifiant) {
		if(!identifiant.isEmpty() && userService.recupererUser(identifiant)!=null ) {
			ModelAndView mav = new ModelAndView("pageclient");
			mav.addObject("userConnecte",userService.recupererUser(identifiant));
			mav.addObject("Quiz",quizService.recupererQuizs());
			return mav;
		}else {
			return new ModelAndView("redirect:/index");
		}
		
	}
	
	@GetMapping("newQuestions")
	public ModelAndView newQuestionGet(@RequestParam("nbQuestions") Long nbQuestions,@RequestParam("idQuiz") Long idQuiz) {

		ModelAndView mav = new ModelAndView("newQuestions");
		mav.addObject("nbQuestions",nbQuestions);
		mav.addObject("idQuiz",idQuiz);
		return mav;
		
	}
	
	@GetMapping("newQuiz")
	public ModelAndView newQuizGet() {

		ModelAndView mav = new ModelAndView("newQuiz");
		return mav;
		
	}
	
	@PostMapping("questionsNewPost")
	public ModelAndView newQuestionsPost(@RequestParam("question") String intitule,
			@RequestParam("idQuiz") Long idQuiz,
			@RequestParam("nbQuestions") Long nbQuestions,
			@RequestParam("reponse1") String reponse1,
			@RequestParam("reponse2") String reponse2,
			@RequestParam("reponse3") String reponse3,
			@RequestParam("reponse4") String reponse4,
			@RequestParam("reponse1Check") String reponse1Check,
			@RequestParam("reponse2Check") String reponse2Check,
			@RequestParam("reponse3Check") String reponse3Check,
			@RequestParam("reponse4Check") String reponse4Check) {
		if(nbQuestions>0) {
			System.out.println(reponse1Check);
			System.out.println(reponse2Check);
			System.out.println(reponse3Check);
			System.out.println(reponse4Check);
			List <Reponse> reponses= new ArrayList();
			Question q = questionService.ajouterQuestion(intitule, null, null, null, quizService.recupererQuiz(idQuiz));
			
			reponses.add(reponseService.ajouterReponse(reponse1, (reponse1Check=="1") ? true:false, q));
			reponses.add(reponseService.ajouterReponse(reponse2, (reponse2Check=="1") ? true:false, q));
			reponses.add(reponseService.ajouterReponse(reponse3, (reponse3Check=="1") ? true:false, q));
			reponses.add(reponseService.ajouterReponse(reponse4, (reponse4Check=="1") ? true:false, q));
			
			questionService.ajouterReponses(reponses, q);
			
			return new ModelAndView("redirect:/newQuestions?nbQuestions="+nbQuestions+"&idQuiz="+idQuiz);
		}else {
			return new ModelAndView("redirect:/pageadmin");
		}
		
	}
	
	@PostMapping("newQuizPost")
	public ModelAndView newQuizPost(@RequestParam("intitule") String intitule,@RequestParam("nbQuestions") Long nbQuestions) {
		if(intitule != "") {
			Quiz quiz =quizService.ajouterQuiz(intitule,null,null);
			return new ModelAndView("redirect:/newQuestions?nbQuestions="+nbQuestions+"&idQuiz="+quiz.getId());
		}
		else {
			return new ModelAndView("redirect:/newQuiz");
		}
		
	}
	
	@PostMapping("SignIn")
	public RedirectView connexion(@RequestParam("IDENTIFIANT") String identifiant, @RequestParam("MOT_DE_PASSE") String motDePasse) {
		if(userService.recupererUser(identifiant) != null) {
			if (userService.recupererUser(identifiant).getMotDePasse().equals(motDePasse)) {
				if(userService.recupererUser(identifiant).getAdmin()==true) {
					return new RedirectView("pageadmin");
				}
				else {
					return new RedirectView("pageclient?IDU="+identifiant);
				}
			}
			else {
				return new RedirectView("index");
			}
		}
		else {
			return new RedirectView("index");
		}
	}
	
	@GetMapping("pageadmin")
	public ModelAndView pageAdminGet() {
		ModelAndView mav = new ModelAndView("pageadmin");
		mav.addObject("quizs", quizService.recupererQuizs());
		return mav;
	}
	
	@GetMapping("inscription")
	public ModelAndView pageInscriptionGet() {
		ModelAndView mav = new ModelAndView("inscription");
		return mav;
	}
	@PostMapping("inscriptionPost")
	public ModelAndView inscriptionPost(@RequestParam("IDENTIFIANT") String identifiant, @RequestParam("MOT_DE_PASSE") String mdp, @RequestParam("CODE_ADMIN") String codeAdmin) {
		if(userService.recupererUser(identifiant) == null) {
			if(codeAdmin.equals("admin")) {
				userService.ajouterUser(mdp, identifiant, true, null, null);
			}
			else {
				userService.ajouterUser(mdp, identifiant, false, null, null);
			}
			return new ModelAndView("redirect:/");
		}
		else {
			return new ModelAndView("redirect:/inscription");
		}
	}
	
	@GetMapping ("result")
	  public ModelAndView getResult( @RequestParam("IDU") Long idUser,  @RequestParam("IDQ") Long idQuiz  ) {
	    ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		mav.addObject("user", userService.recupererUser(idUser));
		mav.addObject("quiz", quizService.recupererQuiz(idQuiz));
		mav.addObject("score", scoreService.recupererScoreOfUserForQuiz(idUser, idQuiz));
		return mav;
	  }
	
	@GetMapping ("questionsJeu")
	public ModelAndView playQuiz(@RequestParam("IDQ") Long idQuiz,
			/*@RequestParam(name = "nQuestion", defaultValue = "0") int nQuestion,*/
			@RequestParam(name = "IDU") Long idUser) {
		System.out.println(idQuiz);
		ModelAndView mav = new ModelAndView();	
		mav.setViewName("questionsJeu");

		mav.addObject("quiz", quizService.recupererQuiz(idQuiz));
		//mav.addObject("question", quizService.recupererQuiz(idQuiz).getQuestions().get(nQuestion));
		//mav.addObject("reponses", quizService.recupererQuiz(idQuiz).getQuestions().get(nQuestion).getReponses());
		//mav.addObject("nQuestion", nQuestion);
		mav.addObject("user", userService.recupererUser(idUser));
		
			if(scoreService.recupererScoreOfUserForQuiz(idUser, idQuiz) == null) {
				scoreService.ajouterScore(0L, userService.recupererUser(idUser), quizService.recupererQuiz(idQuiz));
			}
			else {
				scoreService.mettreaJourScore(0L, userService.recupererUser(idUser), quizService.recupererQuiz(idQuiz));
			}
		
		return mav;
	}
	
	@PostMapping ("questionSuivante")
	public ModelAndView nextQuestion(
			@RequestParam(name = "reponse0", required = false) String reponse0,
			@RequestParam(name = "reponse1", required = false) String reponse1,
			@RequestParam(name = "reponse2", required = false) String reponse2,
			@RequestParam(name = "reponse3", required = false) String reponse3,
			@RequestParam(name = "idQuestion") Long idQuestion,
			@RequestParam(name = "nQuestion") int nQuestion,
			@RequestParam(name = "IDQ") Long idQuiz,
			@RequestParam(name = "IDU") Long idUser
			) {
		
		System.out.println(reponse0);
		System.out.println(reponse1);
		System.out.println(reponse2);
		System.out.println(reponse3);
		List<String> reponses = new ArrayList<String>();
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
		System.out.println(reponses.get(0));
		List<String> vraiReponses = new ArrayList<String>();
		questionService.recupererQuestion(idQuestion).getReponses().forEach((resp)->{
			if (resp.getIsCorrect()== true) {
				vraiReponses.add(resp.getIntitule());
			}
		});
		
		System.out.println(vraiReponses.get(0));
		System.out.println(scoreService.recupererScoreOfUserForQuiz(idUser, idQuiz).getValue());
		
		if (reponses.equals(vraiReponses)) {
			System.out.println("c'est pas là que ça merde");
			scoreService.incrementScore(/*userService.recupererUser(idUser), quizService.recupererQuiz(idQuiz)*/scoreService.recupererScoreOfUserForQuiz(idUser, idQuiz));
			// scoreService.incrementScore(userService.recupererUser(1L), quizService.recupererQuiz(idQuiz));
			// TODO incrementer le score 
		}
		System.out.println(scoreService.recupererScoreOfUserForQuiz(idUser, idQuiz).getValue());
		int nmaxQuestions = quizService.recupererQuiz(idQuiz).getQuestions().size();
		
		nQuestion++;
		
		if (nQuestion>=nmaxQuestions) {
			String redir = "redirect:/result?IDQ=";
			redir = redir.concat(Long.toString(idQuiz));
			redir = redir.concat("&IDU=");
			redir = redir.concat(Long.toString(idUser));
			return new ModelAndView(redir);
		}
		else {
			String redir = "redirect:/questionsJeu?IDQ=";
			redir = redir.concat(Long.toString(idQuiz));
			redir = redir.concat("&nQuestion=");
			redir = redir.concat(Integer.toString(nQuestion));
			redir = redir.concat("&IDU=");
			redir = redir.concat(Long.toString(idUser));

			return new ModelAndView(redir) ;
		}

	}
	
	@PostConstruct
	public void init() {
		System.out.println("Dans init()");
		if(userService.recupererUsers().isEmpty()) {
			userService.ajouterUser("testadmin", "testadmin", true, null, null);
			userService.ajouterUser("testclient", "testclient", false, null, null);
		}
		if(niveauService.recupererNiveaux().isEmpty()) {
			niveauService.ajouterNiveau("Débutant");
			niveauService.ajouterNiveau("Intermédiaire");
			niveauService.ajouterNiveau("Expert");
		}
		if (quizService.recupererQuizs().isEmpty()) {
			quizService.ajouterQuiz("Mary me", userService.recupererUser(2L),null);
			}
		if(questionService.recupererQuestions().isEmpty()) {
			questionService.ajouterQuestion("What is Carl's favorite food?", null, niveauService.recupererNiveau(1L), "Mariage", quizService.recupererQuiz(1L));
		}
		if(reponseService.recupererReponses().isEmpty()) {
		reponseService.ajouterReponse("Cake", true, questionService.recupererQuestion(1L));
		reponseService.ajouterReponse("Brownies", false, questionService.recupererQuestion(1L));
		reponseService.ajouterReponse("Pasta", false, questionService.recupererQuestion(1L));
		reponseService.ajouterReponse("Pizza", false, questionService.recupererQuestion(1L));
		}
	}
}