package sofrecom.collaborateur.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sofrecom.collaborateur.model.Campagne;
import sofrecom.collaborateur.model.DAOUser;
import sofrecom.collaborateur.model.Entretien;
import sofrecom.collaborateur.model.Objectif;
import sofrecom.collaborateur.model.Status;
import sofrecom.collaborateur.repository.CampagneRepository;
import sofrecom.collaborateur.repository.EntretientRepository;
import sofrecom.collaborateur.repository.UserRepository;
import sofrecom.collaborateur.service.IEntretienService;

@Component
public class EntretienService implements IEntretienService {
	
	
	@Autowired
	EntretientRepository EntretienRepo;
	
	@Autowired
	UserRepository UserRepo;
	
	@Autowired
	CampagneService camapagneService;
	
	@Autowired
	CampagneRepository campagneRepository;

	@Override
	public List<Entretien> getEIPsByManager(long id) {
		return null;
	}

	@Override
	public DAOUser getCollaborateurByEntretien(Entretien entretien) {
		
		String userEmail = entretien.getUser().getEmail();
		DAOUser user = UserRepo.findByEmail(userEmail);
		return user;
	}

	@Override
	public Entretien getEntretienByCollaborateur(long userId) {
		Entretien entretien = EntretienRepo.findEntretienByUserId(userId);
		return entretien;
	}
	
	@Override
	public Entretien getEntretienByCollaborateurAndCompagne(long userId) {
		String key = camapagneService.getSemesterAndYear();
		Entretien entretien = EntretienRepo.findEntretienByUserIdAndCompagne(userId,key);
		return entretien;
	}
	@Override
	public void newEntretient(Entretien entretien,long id) {
		DAOUser user = UserRepo.findById(id).get();
		entretien.setUser(user);
		
		String key = camapagneService.getSemesterAndYear();
		
		Campagne campagne = campagneRepository.findById(key).get();
		
		entretien.setCampagne(campagne);
		entretien.setStatus(Status.AUTO_EVALUATION);
		EntretienRepo.save(entretien);		
	}

	@Override
	public DAOUser getCollaborateurByEntretien(long id) {
		return EntretienRepo.findCollaborateurByEntretien(id);
	}

	@Override
	public void newProjet(Entretien ent, long userId) {

		String key = camapagneService.getSemesterAndYear();
			
		Entretien entretien = EntretienRepo.findEntretienByUserIdAndCompagne(userId,key);
		entretien.setStatus(Status.PROJET_PROFESSIONEL);
		entretien.setProjet(ent.getProjet());
		entretien.setFormations(ent.getFormations());
		
		EntretienRepo.save(entretien);
	}
}
