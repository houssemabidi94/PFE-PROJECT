package sofrecom.collaborateur.service;

import java.util.List;

import sofrecom.collaborateur.model.Objectif;

public interface IObjectifService {
	
	public List<Objectif> getAllObjectifs(String campagneID,long userID);

	public void autoEvaluateObjectif(Objectif objectif);
	

}
