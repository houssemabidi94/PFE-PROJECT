package sofrecom.collaborateur.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import sofrecom.collaborateur.model.Competence;
import sofrecom.collaborateur.repository.EvaluationRepository;
import sofrecom.collaborateur.service.ICompetenceService;
import sofrecom.collaborateur.serviceImpl.UserService;

@RestController
public class CompetenceController {

	@Autowired
	ICompetenceService competenceService;
	@Autowired
	EvaluationRepository evalRepo;
	@Autowired
	UserService userService;

	
	@GetMapping("competences")
	public List<Competence> getCompetenceList() {
		return competenceService.getCompetenceList();
	}
	
	@GetMapping("/getusercompetence")
	public List<String> getUserCompetence(HttpServletRequest request){
		
		long userID = userService.getCurrentUserId(request);
		
		
		List<String> eval = evalRepo.getCompetenceEvaluated(userID);
		
		return eval;
	}
}
