package sofrecom.collaborateur.serviceImpl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import sofrecom.collaborateur.model.Fonction;
import sofrecom.collaborateur.repository.FonctionRepository;

@Service
public class FonctionService {

	@Autowired
	private FonctionRepository fonctionRepository;

}
