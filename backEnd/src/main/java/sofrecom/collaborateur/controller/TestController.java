package sofrecom.collaborateur.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import sofrecom.collaborateur.config.JwtTokenUtil;
import sofrecom.collaborateur.model.Competence;
import sofrecom.collaborateur.model.DAOUser;
import sofrecom.collaborateur.model.Entretien;
import sofrecom.collaborateur.model.Evaluation;
import sofrecom.collaborateur.model.Objectif;
import sofrecom.collaborateur.repository.EntretientRepository;
import sofrecom.collaborateur.repository.EvaluationRepository;
import sofrecom.collaborateur.repository.FonctionRepository;
import sofrecom.collaborateur.repository.ObjectifRepository;
import sofrecom.collaborateur.repository.UserRepository;
import sofrecom.collaborateur.service.IObjectifService;
import sofrecom.collaborateur.service.SendMailService;
import sofrecom.collaborateur.serviceImpl.CampagneService;
import sofrecom.collaborateur.serviceImpl.EntretienService;
import sofrecom.collaborateur.serviceImpl.UserService;

@RestController
public class TestController {

	@Autowired
	FonctionRepository fonctionRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	JwtTokenUtil jwt;
	
	@Autowired
	CampagneService cs;
	
	@Autowired
	IObjectifService objectifService;
	
	@Autowired
	ObjectifRepository objectifRepo;
	
	@Autowired
	EntretienService entretienService ;
	
	@Autowired
	SendMailService service;
	
	@Autowired
	EvaluationRepository evalRepo;
	
	@Autowired
	EntretientRepository entser;
	
	@GetMapping("/fonction")
	public String getUserFonction(HttpServletRequest request) {
		

		long userId = userService.getCurrentUserId(request);

		String fonction = userRepo.getUserFullname(userId);
				return fonction;
	}
	@GetMapping("/users")
	public List<Long> getUsersManager(HttpServletRequest request) {
		final String requestTokenHeader = request.getHeader("Authorization");
		String jwtToken = requestTokenHeader.substring(7);

		String email = jwt.getUsernameFromToken(jwtToken);

		long managerID = userRepo.getUserId(email);

		List<Long> users = userRepo.getUsersIdByManagerId(managerID);
		return users;
	}



}
