package sofrecom.collaborateur.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sofrecom.collaborateur.model.DAOUser;
import sofrecom.collaborateur.model.Entretien;
import sofrecom.collaborateur.model.Objectif;
import sofrecom.collaborateur.repository.EntretientRepository;
import sofrecom.collaborateur.repository.ObjectifRepository;
import sofrecom.collaborateur.repository.UserRepository;
import sofrecom.collaborateur.serviceImpl.CampagneService;
import sofrecom.collaborateur.serviceImpl.EntretienService;
import sofrecom.collaborateur.serviceImpl.UserService;

@RestController
public class EntretienController {
	
	@Autowired
	EntretienService entretienService;
	

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ObjectifRepository objectifRepo;
	
	@Autowired
	EntretientRepository entretientRepo;
	
	@Autowired
	CampagneService cs;
	
	@GetMapping("EIPs/{idManager}")
	public List<Entretien> getEIPsByManager(@PathVariable("idManager") long id) {
		return entretienService.getEIPsByManager(id);
	}
	

	
	@GetMapping("findEntretienByCollaborateur/{idCollaborateur}")
	public Entretien getEntretienByCollaborateur(@PathVariable("idCollaborateur") long id) {
		return entretienService.getEntretienByCollaborateur(id);
	}
	
	@PostMapping("newEntretient")
	@ResponseBody
	public void setToEntretien(@RequestBody Entretien entretient,HttpServletRequest request) {
		long userId = userService.getCurrentUserId(request);
		
		entretienService.newEntretient(entretient, userId);
		
	}
	
	@GetMapping("/eips")
	public List<Entretien> UsersEvalByManagerId(HttpServletRequest request) {

		long userId = userService.getCurrentUserId(request);
		List<Long> users = userRepo.getUsersIdByManagerId(userId);
		String key = cs.getSemesterAndYear();
		
		List<Entretien> ent = new ArrayList<Entretien>();
		
		for(long userID : users) {
			ent.addAll(entretientRepo.findEntretien(userID,key)); 
		}
		return ent;
	}
}

