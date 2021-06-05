package sofrecom.collaborateur.service;

import java.util.List;

import sofrecom.collaborateur.model.Evaluation;

public interface IEvaluationService {

	
	public Evaluation addEvaluationByUserAndCompetence(long idUser,long idCompetence , long idNiveau);

	List<Evaluation> getUserEval(long id, long compId);
}
