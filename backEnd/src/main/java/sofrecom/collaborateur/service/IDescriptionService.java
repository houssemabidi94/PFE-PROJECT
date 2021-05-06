package sofrecom.collaborateur.service;


import java.util.List;

import sofrecom.collaborateur.model.Description;

public interface IDescriptionService {

	List<Description> getDescriptionList();

	Description getDescription(long idCompetence, long idNiveau);

	List<Description> getDescByCompetence(long id);

	Description addDescription(long idEntretien, Description description);


}
