package sofrecom.collaborateur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sofrecom.collaborateur.model.Entretien;
import sofrecom.collaborateur.serviceImpl.ClotureService;

@RestController
public class ClotureController {

	@Autowired
	ClotureService clotureService ;
	
	
	@PutMapping("cloturer/{userId}")
	@ResponseBody
	public void cloturer(@RequestBody Entretien entretient,@PathVariable("userId") long userId) {
		
		clotureService.cloturer(entretient,userId);
		
	}
}
