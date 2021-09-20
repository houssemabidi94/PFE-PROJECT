package sofrecom.collaborateur.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@Autowired
	EntretientRepository entser;

	@GetMapping("findEntretienByCollaborateur/{idCollaborateur}")
	public Entretien getEntretienByCollaborateur(@PathVariable("idCollaborateur") long id) {
		return entretienService.getEntretienByCollaborateur(id);
	}

	@GetMapping("findEntretienByCollaborateurAndCompagne/{idCollaborateur}")
	public Entretien getEntretienByCollaborateurAndCompagne(@PathVariable("idCollaborateur") long id) {
		return entretienService.getEntretienByCollaborateurAndCompagne(id);
	}

	@PostMapping("newEntretient")
	@ResponseBody
	public void setToEntretien(@RequestBody Entretien entretient, HttpServletRequest request) {
		long userId = userService.getCurrentUserId(request);

		entretienService.newEntretient(entretient, userId);

	}

	@GetMapping("/eips")
	public List<Entretien> UsersEvalByManagerId(HttpServletRequest request) {

		long userId = userService.getCurrentUserId(request);
		List<Long> users = userRepo.getUsersIdByManagerId(userId);
		String key = cs.getPreviousSemester();

		List<Entretien> ent = new ArrayList<Entretien>();

		for (long userID : users) {
			ent.addAll(entretientRepo.findCollabsEntretien(userID, key));
		}
		return ent;
	}

	@GetMapping("findCollaborateurByEntretien/{idEntretien}")
	public DAOUser getCollaborateurByEntretien(@PathVariable("idEntretien") long id) {
		return entretienService.getCollaborateurByEntretien(id);
	}

	@PutMapping("addNewProjet/{idUser}")
	@ResponseBody
	public void addNewProjet(@RequestBody Entretien entretient, @PathVariable("idUser") long userId) {

		entretienService.newProjet(entretient, userId);

	}

	@GetMapping("/entretien")
	public Entretien getUserEntretien(HttpServletRequest request) {

		long userId = userService.getCurrentUserId(request);

		String key = cs.getSemesterAndYear();
		Entretien ent = entser.findEntretienByUserIdAndCompagne(userId, key);
		return ent;
	}
}
