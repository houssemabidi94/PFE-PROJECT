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
	private EntretientRepository EntretientRepo;
	
	@Override
	public void cloturer(long userId) {
	Entretien entretien = EntretientRepo.findEntretienByUserId(userId);
	entretien.setStatus(Status.CLOTURE);
	EntretientRepo.save(entretien);
}
}