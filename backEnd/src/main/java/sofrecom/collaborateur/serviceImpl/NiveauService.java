package sofrecom.collaborateur.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import sofrecom.collaborateur.model.Campagne;
import sofrecom.collaborateur.model.Niveau;
import sofrecom.collaborateur.repository.NiveauRepository;
import sofrecom.collaborateur.service.INiveauService;

@Service
public class NiveauService implements INiveauService{
	
	@Autowired
	NiveauRepository niveauRepo;
	
//	List<String> niveaux = Arrays.asList("Niveau 1", "Niveau 2", "Niveau 3","Niveau 4","Niveau 5");
//
//	@Bean
//	InitializingBean setNiveaux() {
//		return () -> {
//			for (int i = 0; i < niveaux.size(); i++) {
//
//			niveauRepo.save(new Niveau(i+1,niveaux.get(i)));
//			}
//		};
//	}
	
	
	@Override
	public List<Niveau> getNiveauList() {
		return (List<Niveau>) niveauRepo.findAll();
	}

}
