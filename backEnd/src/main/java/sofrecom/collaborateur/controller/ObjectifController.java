package sofrecom.collaborateur.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sofrecom.collaborateur.config.JwtTokenUtil;
import sofrecom.collaborateur.model.Entretien;
import sofrecom.collaborateur.model.Objectif;
import sofrecom.collaborateur.repository.ObjectifRepository;
import sofrecom.collaborateur.repository.UserRepository;
import sofrecom.collaborateur.service.IObjectifService;
import sofrecom.collaborateur.serviceImpl.CampagneService;
import sofrecom.collaborateur.serviceImpl.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ObjectifController {

	@Autowired
	IObjectifService objectifService;

	@Autowired
	ObjectifRepository objectifRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	CampagneService cs;

	@Autowired
	JwtTokenUtil jwt;
	
	@Autowired
	UserService userService;

	@GetMapping("/objectif")
	public List<Objectif> getObjectifsList(HttpServletRequest request) {
		long userId = userService.getCurrentUserId(request);

		String key = cs.getPreviousSemester();
		List<Objectif> obj = objectifRepo.findObjectif(key, userId);
		return obj;
	}

	@PutMapping("/objectif")
	@ResponseBody
	public void autoEvaluateObjectif(@RequestBody Objectif objectif) {
		objectifService.autoEvaluateObjectif(objectif);
	}
	@PutMapping("evaluateObjectif")
	@ResponseBody
	public void evaluateObjectif(@RequestBody Objectif objectif) {
		objectifService.evaluateObjectif(objectif);
	}
	@PutMapping("newObjectif/{id}")
	@ResponseBody
	public void newObjectif(@PathVariable(value="id") long id, @RequestBody Objectif objectif) {
		objectifService.newObjectif(objectif, id);
	}
	
	@GetMapping("newobjectifsForManager/{idCollaborateur}")
	public List<Objectif> getCollaborateurNewObjectifsForManager(@PathVariable("idCollaborateur") long id) {
		return objectifService.getCollaborateurNewObjectifsForManager(id);

	}
	@GetMapping("objectifsForManager/{idCollaborateur}")
	public List<Objectif> getCollaborateurObjectifsForManager(@PathVariable("idCollaborateur") long id) {
		return objectifService.getCollaborateurObjectifsForManager(id);

	}
	
	@GetMapping("/objectifevaluatedbycollab/{userID}")
	public List<Objectif> getObjectifEvaluatedByCollab(HttpServletRequest request ,@PathVariable long userID){
		
		String key = cs.getPreviousSemester();
		
		List<Objectif> obj = objectifRepo.findObjectifEvaluatedByCollab(key, userID);

		return obj;
	}
	
	@GetMapping("/newobjectifs")
	public List<Objectif> getNewObjectifsList(HttpServletRequest request) {
		long userId = userService.getCurrentUserId(request);

		String key = cs.getSemesterAndYear();
		List<Objectif> obj = objectifRepo.findObjectif(key, userId);
		return obj;
	}
	
	@GetMapping("/objectifevaluatedbymanager")
	public List<Objectif> getObjectifEvaluatedByManager(HttpServletRequest request){
		
		long userID = userService.getCurrentUserId(request);
		
		String key = cs.getPreviousSemester();
		
		List<Objectif> obj = objectifRepo.findObjectifEvaluatedByManager(key, userID);

		return obj;
	}
}
