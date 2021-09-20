package sofrecom.collaborateur.service;

import java.util.List;



import sofrecom.collaborateur.model.DAOUser;
import sofrecom.collaborateur.model.Entretien;

public interface IEntretienService {
	
	public List<Entretien> getEIPsByManager(long id);
	public DAOUser getCollaborateurByEntretien(long id) ;
	public Entretien getEntretienByCollaborateur(long id) ;
	void newEntretient(Entretien entretien, long id);
	public DAOUser getCollaborateurByEntretien(Entretien entretien);
	void newProjet(Entretien ent, long userId);
	Entretien getEntretienByCollaborateurAndCompagne(long userId);
}
