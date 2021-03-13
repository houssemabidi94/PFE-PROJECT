package sofrecom.collaborateur.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sofrecom.collaborateur.config.JwtTokenUtil;
import sofrecom.collaborateur.model.Objectif;
import sofrecom.collaborateur.repository.ObjectifRepository;
import sofrecom.collaborateur.repository.UserRepository;
import sofrecom.collaborateur.service.IObjectifService;
import sofrecom.collaborateur.serviceImpl.CampagneService;

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

	@GetMapping("/objectif")
	public List<Objectif> getObjectifsList(HttpServletRequest request) {
		final String requestTokenHeader = request.getHeader("Authorization");
		String jwtToken = requestTokenHeader.substring(7);

		String email = jwt.getUsernameFromToken(jwtToken);

		long userID = userRepo.getUserId(email);

		String key = cs.getPreviousSemester();
		List<Objectif> obj = objectifRepo.findObjectif(key, userID);
		return obj;
	}

    @PutMapping("/objectif")
    @ResponseBody
    public void autoEvaluateObjectif(@RequestBody Objectif objectif) {
    objectifService.autoEvaluateObjectif(objectif);
}

}
