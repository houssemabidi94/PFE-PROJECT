package sofrecom.collaborateur.service;

import sofrecom.collaborateur.model.Entretien;

public interface IClotureService {

	void cloturer(Entretien ent,long userId);

}
