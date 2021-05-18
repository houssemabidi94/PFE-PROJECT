package sofrecom.collaborateur.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import sofrecom.collaborateur.model.Evaluation;
import sofrecom.collaborateur.service.IEvaluationService;

@RestController
public class EvaluationController {

	@Autowired
	IEvaluationService evaluationService;
	
	@PutMapping("newEvaluation/{idUser}/{idCompetence}/{idNiveau}")
	public Evaluation addEvaluationByUserAndCompetence(@PathVariable("idUser") long idUser,@PathVariable("idCompetence") long idCompetence,@PathVariable("idNiveau") long idNiveau) {
		return evaluationService.addEvaluationByUserAndCompetence(idUser,idCompetence,idNiveau);
	}				
}
