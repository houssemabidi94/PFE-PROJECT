package sofrecom.collaborateur.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sofrecom.collaborateur.model.Entretien;
import sofrecom.collaborateur.model.Status;
import sofrecom.collaborateur.repository.EntretientRepository;
import sofrecom.collaborateur.service.IClotureService;

@Component
public class ClotureService implements IClotureService{

	@Autowired
	private EntretientRepository EntretienRepo;
	
	@Autowired
	CampagneService camapagneService;
	
	@Override
	public void cloturer(Entretien ent,long userId) {
		
		String key = camapagneService.getSemesterAndYear();
		
		Entretien entretien = (Entretien) EntretienRepo.findEntretienByUserIdAndCompagne(userId,key);
	entretien.setStatus(Status.CLOTURE);
	entretien.setRemarque(ent.getRemarque());
	EntretienRepo.save(entretien);
}
}