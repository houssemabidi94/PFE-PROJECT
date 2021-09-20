package sofrecom.collaborateur.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sofrecom.collaborateur.model.Entretien;
import sofrecom.collaborateur.model.Evaluation;
import sofrecom.collaborateur.model.EvaluationPK;
import sofrecom.collaborateur.model.Objectif;
import sofrecom.collaborateur.model.Status;
import sofrecom.collaborateur.repository.EntretientRepository;
import sofrecom.collaborateur.repository.EvaluationRepository;
import sofrecom.collaborateur.service.IEvaluationService;

@Service
public class EvaluationService implements IEvaluationService {
		
	@Autowired
	EvaluationRepository evalRepo;

	@Autowired
	EntretientRepository EntretienRepo;
	
	@Override
	public Evaluation addEvaluationByUserAndCompetence(long idUser, long idCompetence, long idNiveau) {
		EvaluationPK evalPK = new EvaluationPK();
		evalPK.setIdUser(idUser);
		evalPK.setIdCompetence(idCompetence);
		evalPK.setIdNiveau(idNiveau);
		Evaluation eval = new Evaluation();
		eval.setEvaluationPK(evalPK);
		evalRepo.save(eval);
		Entretien entretien = EntretienRepo.findEntretienByUserId(idUser);
		entretien.setStatus(Status.EVALUATION_COMPETENCES);
		EntretienRepo.save(entretien);
		return eval;
	}
	
	@Override
	public List<Evaluation> getUserEval(long id,long compId) {
			
		List<Evaluation> eval = evalRepo.getEvalByUserId(id,compId);
		return eval;

	}
}
