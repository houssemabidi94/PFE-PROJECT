package sofrecom.collaborateur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import sofrecom.collaborateur.serviceImpl.ClotureService;

@RestController
public class ClotureController {

	@Autowired
	ClotureService clotureService ;
	
	
	@PostMapping("cloturer/{userId}")
	public void cloturer(@PathVariable("userId") long userId) {
		
		clotureService.cloturer(userId);
		
	}
}
