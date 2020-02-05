

package fr.tse.quiz.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.multipart.MultipartFile;
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
	private static String UPLOADED_FOLDER = "src/main/webapp/style/";
	  
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
		System.out.println("la pagee client");
		System.out.println(identifiant);
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
		mav.addObject("niveaux", niveauService.recupererNiveaux());
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
			@RequestParam("niveau") Long idNiveau,
			@RequestParam("theme") String theme,
			@RequestParam("lien_pdf") MultipartFile file,
			@RequestParam("nbQuestions") Long nbQuestions,
			@RequestParam("reponse1") String reponse1,
			@RequestParam("reponse2") String reponse2,
			@RequestParam("reponse3") String reponse3,
			@RequestParam("reponse4") String reponse4,
			@RequestParam("reponse1Check") String reponse1Check,
			@RequestParam("reponse2Check") String reponse2Check,
			@RequestParam("reponse3Check") String reponse3Check,
			@RequestParam("reponse4Check") String reponse4Check) throws IOException {
		
		
		byte[] bytes = file.getBytes();
	
		String lienPdf = intitule+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		Path relativePath = Paths.get(UPLOADED_FOLDER+lienPdf);
	
		Path absolutePath = relativePath.toAbsolutePath();
	
		System.out.println("Current relative path is: " + absolutePath.toString());
		
        Files.write(absolutePath, bytes);
        
		List <Reponse> reponses= new ArrayList();
		Question q = questionService.ajouterQuestion(intitule, lienPdf, niveauService.recupererNiveau(idNiveau), theme, quizService.recupererQuiz(idQuiz));
		System.out.println(reponse1Check.contentEquals("1"));
		System.out.println(reponse2Check);
		
		reponses.add(reponseService.ajouterReponse(reponse1, reponse1Check.contentEquals("1"), q));
		reponses.add(reponseService.ajouterReponse(reponse2, reponse2Check.contentEquals("1"), q));
		reponses.add(reponseService.ajouterReponse(reponse3, reponse3Check.contentEquals("1"), q));
		reponses.add(reponseService.ajouterReponse(reponse4, reponse4Check.contentEquals("1"), q));	
		questionService.ajouterReponses(reponses, q);
		
		if(nbQuestions>0) {
	
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
	
	  @GetMapping ("delete")
	    public ModelAndView deleteQuiz(  @RequestParam("IDQ") Long idQuiz  ) {
	    delete(idQuiz);
	    return new ModelAndView("redirect:/pageadmin");
	    }
	  
	  @DeleteMapping
	  public void delete ( Long idQuiz ) {
		  quizService.supprimerQuiz(quizService.recupererQuiz(idQuiz));
		  
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
		mav.addObject("userConnecte", userService.recupererUser(idUser));
		mav.addObject("quiz", quizService.recupererQuiz(idQuiz));
		mav.addObject("score", scoreService.recupererScoreOfUserForQuiz(idUser, idQuiz));
		
		return mav;
	  }
	
	
	
	@GetMapping ("questionsJeu")
	public ModelAndView playQuiz(@RequestParam("IDQ") Long idQuiz,
			@RequestParam(name = "nQuestion", defaultValue = "0") int nQuestion,
			@RequestParam(name = "IDU") Long idUser) {
		
		int nmaxQuestions = quizService.recupererQuiz(idQuiz).getQuestions().size();
		if (nQuestion>=nmaxQuestions) {
			String redir = "redirect:/result?IDQ=";
			redir = redir.concat(Long.toString(idQuiz));
			redir = redir.concat("&IDU=");
			redir = redir.concat(Long.toString(idUser));
			return new ModelAndView(redir);
		}
		
		ModelAndView mav = new ModelAndView();	
		mav.setViewName("questionsJeu");

		mav.addObject("quiz", quizService.recupererQuiz(idQuiz));
		mav.addObject("question", quizService.recupererQuiz(idQuiz).getQuestions().get(nQuestion));
		mav.addObject("reponses", quizService.recupererQuiz(idQuiz).getQuestions().get(nQuestion).getReponses());
		mav.addObject("nQuestion", nQuestion);
		mav.addObject("userConnecte", userService.recupererUser(idUser));
		if (nQuestion==0) {
			if(scoreService.recupererScoreOfUserForQuiz(idUser, idQuiz) == null) {
				scoreService.ajouterScore(0L, userService.recupererUser(idUser), quizService.recupererQuiz(idQuiz));
			}
			else {
				scoreService.mettreaJourScore(0L, userService.recupererUser(idUser), quizService.recupererQuiz(idQuiz));
			}
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
		List<String> vraiReponses = new ArrayList<String>();
		questionService.recupererQuestion(idQuestion).getReponses().forEach((resp)->{
			if (resp.getIsCorrect()== true) {
				vraiReponses.add(resp.getIntitule());
			}
		});
		
		
		if (reponses.equals(vraiReponses)) {
			scoreService.incrementScore(scoreService.recupererScoreOfUserForQuiz(idUser, idQuiz));
			// TODO incrementer le score 
		}
		
		System.out.println(scoreService.recupererScoreOfUserForQuiz(idUser, idQuiz).getValue());
		
		nQuestion++;
		String redir = "redirect:/questionsJeu?IDQ=";
		redir = redir.concat(Long.toString(idQuiz));
		redir = redir.concat("&nQuestion=");
		redir = redir.concat(Integer.toString(nQuestion));
		redir = redir.concat("&IDU=");
		redir = redir.concat(Long.toString(idUser));

		return new ModelAndView(redir) ;
	

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
			questionService.ajouterQuestion("What is Marc favorite food?", null, niveauService.recupererNiveau(1L), "Mariage", quizService.recupererQuiz(1L));
		}
		if(reponseService.recupererReponses().isEmpty()) {
		reponseService.ajouterReponse("Cake", true, questionService.recupererQuestion(1L));
		reponseService.ajouterReponse("Brownies", false, questionService.recupererQuestion(1L));
		reponseService.ajouterReponse("Pasta", false, questionService.recupererQuestion(1L));
		reponseService.ajouterReponse("Pizza", false, questionService.recupererQuestion(1L));
		reponseService.ajouterReponse("Cake", true, questionService.recupererQuestion(2L));
		reponseService.ajouterReponse("Brownies", false, questionService.recupererQuestion(2L));
		reponseService.ajouterReponse("Pasta", false, questionService.recupererQuestion(2L));
		reponseService.ajouterReponse("Pizza", false, questionService.recupererQuestion(2L));
		}
		
			quizService.ajouterQuiz("Mary Nabil", userService.recupererUser(2L),null);
			
		
			questionService.ajouterQuestion("What is Nabil's favorite food", "food.jpg", niveauService.recupererNiveau(1L), "Food", quizService.recupererQuiz(2L));
			questionService.ajouterQuestion("How old is Nabil", "age.jfif", niveauService.recupererNiveau(3L), "Age", quizService.recupererQuiz(2L));
			questionService.ajouterQuestion("What is Nabil's favorite sport ", "sport.jfif", niveauService.recupererNiveau(3L), "Sport", quizService.recupererQuiz(2L));
			questionService.ajouterQuestion("What are Nabil's favorites pets", "animal.jpg", niveauService.recupererNiveau(2L), "Animal", quizService.recupererQuiz(2L));
			questionService.ajouterQuestion("In which city was he born","city.jfif", niveauService.recupererNiveau(3L), "Mariage", quizService.recupererQuiz(2L));
		
			reponseService.ajouterReponse("Cake", false, questionService.recupererQuestion(3L));
			reponseService.ajouterReponse("Brownies", false, questionService.recupererQuestion(3L));
			reponseService.ajouterReponse("Lasagne", true, questionService.recupererQuestion(3L));
			reponseService.ajouterReponse("Pizza", false, questionService.recupererQuestion(3L));
			reponseService.ajouterReponse("24", false, questionService.recupererQuestion(4L));
			reponseService.ajouterReponse("25", false, questionService.recupererQuestion(4L));
			reponseService.ajouterReponse("26", false, questionService.recupererQuestion(4L));
			reponseService.ajouterReponse("27", true, questionService.recupererQuestion(4L));
			reponseService.ajouterReponse("Volei", true, questionService.recupererQuestion(5L));
			reponseService.ajouterReponse("Soccer", false, questionService.recupererQuestion(5L));
			reponseService.ajouterReponse("Basketball", false, questionService.recupererQuestion(5L));
			reponseService.ajouterReponse("Boxe", true, questionService.recupererQuestion(5L));
			reponseService.ajouterReponse("Dog", true, questionService.recupererQuestion(6L));
			reponseService.ajouterReponse("Cat", true, questionService.recupererQuestion(6L));
			reponseService.ajouterReponse("Mouse", false, questionService.recupererQuestion(6L));
			reponseService.ajouterReponse("Tiger", false, questionService.recupererQuestion(6L));
			reponseService.ajouterReponse("Saint-Etienne", false, questionService.recupererQuestion(7L));
			reponseService.ajouterReponse("Paris", false, questionService.recupererQuestion(7L));
			reponseService.ajouterReponse("Lyon", false, questionService.recupererQuestion(7L));
			reponseService.ajouterReponse("Firminy", true, questionService.recupererQuestion(7L));
			
			quizService.ajouterQuiz("La vie d'Antoine", userService.recupererUser(2L),null);
			
			questionService.ajouterQuestion("Quel est le nom de famille d'Antoine ?", "famille.jfif", niveauService.recupererNiveau(2L), "famille", quizService.recupererQuiz(3L));
						questionService.ajouterQuestion("Comment aime-t-il sa blanquette ?", "blanquette.jfif", niveauService.recupererNiveau(2L), "manger", quizService.recupererQuiz(3L));
						questionService.ajouterQuestion("Quelle est sa pointure ?", "pointure.png", niveauService.recupererNiveau(2L), "chaussure", quizService.recupererQuiz(3L));
						questionService.ajouterQuestion("De quelle couleur est son cheval blanc ?", "cheval.jfif", niveauService.recupererNiveau(2L), "manger", quizService.recupererQuiz(3L));
			
			reponseService.ajouterReponse("Martin", false, questionService.recupererQuestion(8L));
					reponseService.ajouterReponse("Bouhélier", false, questionService.recupererQuestion(8L));
					reponseService.ajouterReponse("Peyrard", true, questionService.recupererQuestion(8L));
					reponseService.ajouterReponse("avec des cornichons", false, questionService.recupererQuestion(8L));
					
					reponseService.ajouterReponse("cuite", true, questionService.recupererQuestion(9L));
					reponseService.ajouterReponse("crue", true, questionService.recupererQuestion(9L));
					reponseService.ajouterReponse("congelée", true, questionService.recupererQuestion(9L));
					reponseService.ajouterReponse("en fait il a tout le temps faim", true, questionService.recupererQuestion(9L));
					
					reponseService.ajouterReponse("42", true, questionService.recupererQuestion(10L));
					reponseService.ajouterReponse("43", false, questionService.recupererQuestion(10L));
					reponseService.ajouterReponse("44", false, questionService.recupererQuestion(10L));
					reponseService.ajouterReponse("45", false, questionService.recupererQuestion(10L));
					
					reponseService.ajouterReponse("noir rayé de violet", false, questionService.recupererQuestion(11L));
					reponseService.ajouterReponse("or a pois verts", false, questionService.recupererQuestion(11L));
					reponseService.ajouterReponse("rouge sang", false, questionService.recupererQuestion(11L));
					reponseService.ajouterReponse("42", true, questionService.recupererQuestion(11L));
	}
}

