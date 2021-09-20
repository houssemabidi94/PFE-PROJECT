package sofrecom.collaborateur.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import sofrecom.collaborateur.model.DAOUser;
import sofrecom.collaborateur.model.Description;
import sofrecom.collaborateur.model.DescriptionPK;
import sofrecom.collaborateur.model.Entretien;
import sofrecom.collaborateur.model.Niveau;
import sofrecom.collaborateur.model.Status;
import sofrecom.collaborateur.repository.CompetenceRepository;
import sofrecom.collaborateur.repository.DescriptionRepository;
import sofrecom.collaborateur.repository.EntretientRepository;
import sofrecom.collaborateur.repository.NiveauRepository;
import sofrecom.collaborateur.service.IDescriptionService;

@Service
public class DescriptionService implements IDescriptionService {

	@Autowired
	DescriptionRepository descRepo;

	@Autowired
	CompetenceRepository competenceRepo;
	
	@Autowired
	NiveauRepository niveauRepo;

	@Autowired
	EntretientRepository entretienRepo;
//	
//	//Les niveaux du diplome
//	List<String> niv_dip = Arrays.asList("Inférieur à Bac + 2", "Technicien ou Licence  ( Bac + 3)", "Maitrise ( Bac + 4: Ancien Régime)","Ingénieur Ou master","Ingénieur Grandes Ecoles à l'internationales/Doctorat/E-MBA");
//	//Les niveaux du expérience pro
//	List<String> niv_exppro = Arrays.asList("Inférieur à 2 ans ou Inférieur à 1 an à Sofrecom", "Entre 2 à 5 ans ou de 1 à 4 ans avec 1 an à Sofrecom", "Entre 5 à 8 ans ou de 3 à 6 ans avec 2 ans à Sofrecom","Entre 8 à 12 ans ou de 6 à 10 ans avec 2 ans à Sofrecom","Plus que 12 ans ou plus que 10 ans avec 2 ans à Sofrecom");
//	//Les niveaux du formations et certif
//	List<String> form_cert = Arrays.asList("Au moins une Formation de niveau Associate (niveau basique) sur une compétences de bases du domaine d'exécution", "Une certification de niveau Associate (niveau intermédiaire) sur une compétences de bases du domaine d'exécution", "Au moins deux Certifications ou formations de niveau Professionnel (niveau avancé) sur une compétences de bases du domaine d'exécution","Au moins une Certification de niveau Expert sur une compétence de base du domaine d'exécution\n"
//			+ "Ou bien plusieurs certifications de Niveau Associate et Professionnelles sur des compétences de bases du domaine d'exécution","Au moins une Certification de niveau Expert sur une compétence pointue ou rare: une technologie, une méthodologie ou des compétences à forte valeur ajoutée pour l'entreprise ou il y a très peu de personnes qui maitrisent et y sont certifiées.");
//	//Les niveaux du Connaissances Métiers
//	List<String> métiers = Arrays.asList("Dispose des connaissances métier fondamentales requises pour la réalisation de ses travaux dans les règles de l'art ", "Maitrise des connaissances fondamentales du métier à l'issue d'une mise en pratique de celles-ci sur des cas de complexité moyenne ", "Maitrise avancées des connaissances fondamentales du métier et du SI d'un point de vue fonctionnel l'issue d'une mise en pratique de celles-ci sur des cas complexes.\n"
//			+ "Des connaissances variées sur des domaines de compétences connexes","Dispose de connaissances avancées et pointues du métier et du SI d'un point de vue fonctionnel avec une expertise confirmées sur les domaines de compétences principaux.\n"
//					+ "Des connaissances variées sur des domaines de compétences connexes","Connaissances avancées et pointues du métier avec une expertise confirmées sur plusieurs domaines fonctionnels de compétences et du SI.\n"
//							+ "Des connaissances avancés sur des domaines fonctionnels  de compétences connexes\n"
//							+ "Se tient au courant des nouveautés du domaine / Apprentissage en continu / Une veille technologique  ");
//	//Les niveaux du Maitrise Technique
//	List<String> maitrise = Arrays.asList("Dispose des connaissances fondamentales dans les technologies, les standards et les outils requis pour son poste.", "Maitrise des connaissances fondamentales des technologies, des standards et des outils requis pour son poste. Mise en pratique de celles-ci sur des cas de complexité moyenne ", "Maitrise avancées des connaissances fondamentales des technologies, des standards et des outils requis pour son poste à l'issue d'une mise en pratique de celles-ci sur des cas complexes.\n"
//			+ "Des connaissances variées sur des domaines de compétences connexes","Dispose de connaissances avancées et pointues des technologies, des standards et des outils requis pour son poste  avec une expertise confirmées sur les domaines de compétences principaux.\n"
//					+ "Des connaissances variées sur des domaines de compétences connexes","Connaissances avancées et pointues des technologies, des standards et des outils avec une expertise confirmées sur plusieurs domaines de compétences et technologies de pointe.\n"
//							+ "Des connaissances avancés sur des domaines de compétences connexes\n"
//							+ "Se tient au courant des nouveautés du domaine / Apprentissage en continu / Une veille technologique ");
//	//Les niveaux du Performance Opérationnelle
//	List<String> perf_oper = Arrays.asList("Besoin d'être accompagné par un mentor pour pouvoir réaliser les travaux demandés dans les règles de l'art  et l'application des normes en vigueur", "Réalise les travaux demandés dans les règles de l'art en toute autonomie", "Réalise les travaux demandés dans les règles de l'art. Met en œuvre des bonnes pratiques et des moyens permettant d'optimiser l'exécution du travail et l'amélioration de sa qualité.\n"
//			+ "Apporte souvent de l'aide et du support à ses collègues pour la réalisation de leurs travaux ","Livre un travail de haute qualité. Innove souvent dans sa façon de faire. Propose et met en œuvre de bonnes pratiques et des astuces  pour optimiser et améliorer la qualité.\n"
//					+ "Référent reconnu sur son domaine de compétence au sein de son équipe.","Expert reconnu au delà de son périmètre d'intervention. Référence dans son domaine. Son expertise est considérée comme un levier de développement pour l'entreprise et/ou le client.\n"
//							+ "En s'appuyant sur son expertise, il contribue à la définition de la stratégie de développement de l'entreprise");
//	//Les niveaux du Estimation et Planification des  travaux 
//	List<String> estim_plan = Arrays.asList("Fait l'estimation de ses travaux, comprend le planning fixé et arrive à le tenir.  avec l'aide d'un mentor.", "Fait des estimation fiables de son travail. \n"
//			+ "Organise son travail avec méthode et efficacité pour atteindre les objectifs qui  lui sont fixés.", "Fait des estimations fiables pour des lots de travail de moyenne taille (l'équivalent d'un backlog d'un srprint pour une feature team de 7 personnes).\n"
//					+ "Développe des plannings réalistes et optimisés\n"
//					+ "Connaissances basiques des outils et techniques d'estimation et planifications","Fait des estimation fiables pour des projets et des travaux complexes (L'équivalent d'un backlog d'un projet moyen ~ 60 hommes-mois).\n"
//							+ "Développe des plannings réalistes et optimisés avec prise en considération des risques et des imprévus\n"
//							+ "Maitrise des outils et techniques d'estimation et planifications","Planification stratégique, sur le long terme. Fait des estimations à large échelle: multi projets, multi équipe.\n"
//									+ "Développe des plannings Complexes et optimisés avec prise en considération des risques et des imprévus.\n"
//									+ "Maitrise des outils et technique d'estimation et de planifications avancés");
//
//	
//
//	
//		
//	
//	@Bean
//	InitializingBean setDescriptions() {
//		return () -> {
//			for (int i = 0; i < niv_dip.size(); i++) {
//
//			descRepo.save(new Description(new DescriptionPK(1,i+1),competenceRepo.findByIdCompetence(i+1),niveauRepo.findByIdNiv(i+1),niv_dip.get(i)));
//			descRepo.save(new Description(new DescriptionPK(2,i+1),competenceRepo.findByIdCompetence(i+1),niveauRepo.findByIdNiv(i+1),niv_exppro.get(i)));
//			descRepo.save(new Description(new DescriptionPK(3,i+1),competenceRepo.findByIdCompetence(i+1),niveauRepo.findByIdNiv(i+1),form_cert.get(i)));
//			descRepo.save(new Description(new DescriptionPK(4,i+1),competenceRepo.findByIdCompetence(i+1),niveauRepo.findByIdNiv(i+1),métiers.get(i)));
//			descRepo.save(new Description(new DescriptionPK(5,i+1),competenceRepo.findByIdCompetence(i+1),niveauRepo.findByIdNiv(i+1),maitrise.get(i)));
//			descRepo.save(new Description(new DescriptionPK(6,i+1),competenceRepo.findByIdCompetence(i+1),niveauRepo.findByIdNiv(i+1),perf_oper.get(i)));
//			descRepo.save(new Description(new DescriptionPK(7,i+1),competenceRepo.findByIdCompetence(i+1),niveauRepo.findByIdNiv(i+1),estim_plan.get(i)));
//			}
//
//		};
//	}
	@Override
	public List<Description> getDescriptionList() {
		return (List<Description>) descRepo.findAll();
	}
	@Override
	public Description getDescription(long idCompetence, long idNiveau) {
		DescriptionPK descPK = new DescriptionPK();
		descPK.setIdCompetence(idCompetence);
		descPK.setIdNiveau(idNiveau);
		return descRepo.findByDescriptionPK(descPK);
	}
	
	@Override
	public List<Description> getDescByCompetence(long id) {
		return descRepo.findByCompetenceId(id);
	}
	
	@Override
	public Description addDescription(long idEntretien, Description description) {
		descRepo.save(description);
		Entretien entretien = entretienRepo.findById(idEntretien).get();
		entretien.setStatus(Status.EVALUATION_COMPETENCES);
		entretienRepo.save(entretien);
		return description;
	}
}
