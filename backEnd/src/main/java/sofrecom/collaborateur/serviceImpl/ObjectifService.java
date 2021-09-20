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
import sofrecom.collaborateur.repository.ObjectifRepository;
import sofrecom.collaborateur.repository.UserRepository;
import sofrecom.collaborateur.service.IObjectifService;

@Component
public class ObjectifService implements IObjectifService {

	@Autowired
	private ObjectifRepository ObjectifRepo;

	@Autowired
	private UserRepository UserRepo;

	@Autowired
	private CampagneService campagneService;

	@Autowired
	private CampagneRepository campagneRepository;

	@Autowired
	private EntretientRepository EntretientRepo;

	@Override
	public List<Objectif> getAllObjectifs(String campagneID, long userID) {
		return (List<Objectif>) ObjectifRepo.findObjectif(campagneID, userID);
	}

	@Override
	public void autoEvaluateObjectif(Objectif objectif) {
		Objectif obj = ObjectifRepo.findById(objectif.getId()).get();
		objectif.setEntretien(obj.getEntretien());
		ObjectifRepo.save(objectif);

	}

	@Override
	public void newObjectif(Objectif objectif, long id) {
		// DAOUser user = UserRepo.findById(id).get();

		String key = campagneService.getSemesterAndYear();

		Entretien entretien = EntretientRepo.findEntretienByUserIdAndCompagne(id, key);
		entretien.setStatus(Status.FIXATION_OBJECTIFS);

		objectif.setEntretien(entretien);
		EntretientRepo.save(entretien);
		ObjectifRepo.save(objectif);

	}

	@Override
	public List<Objectif> getCollaborateurObjectifsForManager(long id) {

		String key = campagneService.getPreviousSemester();

		List<Objectif> obj = ObjectifRepo.findObjectif(key, id);
		return obj;

	}

	@Override
	public List<Objectif> getCollaborateurNewObjectifsForManager(long id) {

		String key = campagneService.getSemesterAndYear();

		List<Objectif> obj = ObjectifRepo.findObjectif(key, id);
		return obj;

	}

	@Override
	public void evaluateObjectif(Objectif objectif) {
		Objectif obj = ObjectifRepo.findByIdObjectif(objectif.getId());
		objectif.setAutoEvaluation(obj.getAutoEvaluation());
		objectif.setCommentaire(obj.getCommentaire());
		objectif.setDesignation(obj.getDesignation());
		objectif.setEntretien(obj.getEntretien());
		Entretien entretien = EntretientRepo.findEntretien(obj.getEntretien().getId());
		entretien.setStatus(Status.EVALUATION);
		EntretientRepo.save(entretien);
		ObjectifRepo.save(objectif);
	}

	@Override
	public void feedbackObjectif(Objectif objectif, long userId) {
		Objectif obj = ObjectifRepo.findByIdObjectif(objectif.getId());
	}

}
