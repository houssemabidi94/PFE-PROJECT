package sofrecom.collaborateur.service;

import java.util.List;

import sofrecom.collaborateur.model.Entretien;
import sofrecom.collaborateur.model.Objectif;

public interface IObjectifService {
	
	public List<Objectif> getAllObjectifs(String campagneID,long userID);

	public void autoEvaluateObjectif(Objectif objectif);
	public void newObjectif(Objectif objectif,long id);

	public List<Objectif> getCollaborateurObjectifsForManager(long id);

	public void evaluateObjectif(Objectif objectif);

	void feedbackObjectif(Objectif objectif, long userId);

	List<Objectif> getCollaborateurNewObjectifsForManager(long id);
	

}
