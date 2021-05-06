package sofrecom.collaborateur.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import sofrecom.collaborateur.model.Competence;
import sofrecom.collaborateur.model.Fonction;
import sofrecom.collaborateur.repository.CompetenceRepository;
import sofrecom.collaborateur.service.ICompetenceService;

@Service
public class CompetenceService implements ICompetenceService{
	
	
	@Autowired
	CompetenceRepository competenceRepo;
	
	
	@Override
	public List<Competence> getCompetenceList() {
		return (List<Competence>) competenceRepo.findAll();
	}
//	@Bean
//	InitializingBean setCompetences() {
//		return () -> {
//			competenceRepo.save(new Competence(1,"Diplôme","Plus haute qualification universitaire Obtenue","Documents fournis à l'embauche"));
//			competenceRepo.save(new Competence(2,"Expérience Professionnelle","Niveau de séniorité dans le métier","Fourni par la RH"));
//			competenceRepo.save(new Competence(3,"Formations et Certifications","Formations et certifications Réalisées dehors en du cursus universitaire","Documents fournis à l'embauche + Formations suivies et certifications obtenues à Sofrecom  Sofrecom"));
//			competenceRepo.save(new Competence(4,"Connaissances Métiers","Niveaux des Connaissances et des savoirs Acquis. Pertinence du parcours professionnel et Académique","Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe."));
//			competenceRepo.save(new Competence(5,"Maitrise Technique","Niveau de maitrise de son domaine technique de compétence. En veille sur son domaine.","Suivi Opérationnel : Niveau de performance Coding Game ou autres outils de mesure.Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe"));
//			competenceRepo.save(new Competence(6,"Performance Opérationnelle","Capacité à développer et à mettre en pratique ses connaissances, à utiliser celles-ci pour proposer des approches appropriées aux problématiques rencontrées.","Suivi Opérationnel : Niveau de performance.Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe.KPI projets."));
//			competenceRepo.save(new Competence(7,"Estimation et Planification des  travaux ","Capacité à estimer et à planifier des travaux individuels et collectifs","Suivi Opérationnel : Niveau de performance.Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe.KPI projets"));
//			competenceRepo.save(new Competence(8,"Gestion du temps et des priorités","Capacité à bien exploiter le temps à disposition pour réaliser les travaux en charge et à prioriser les sujets selon leurs importances et urgences","Suivi Opérationnel : Niveau de performance.Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe.KPI projets."));
//			competenceRepo.save(new Competence(9,"Qualité","Capacité à produire les livrables dans le respect des objectifs qualité de Sofrecom ","Suivi Opérationnel : Qualité des livrables"));
//			competenceRepo.save(new Competence(10,"Méthodologie rédactionnelle","Capacité à rédiger des documents complets,  claires et percutants et à rendre aux écrits leur rôle stratégique et tactique dans un contexte professionnel","Suivi Opérationnel : Niveau de Qualité des documents produits"));
//			competenceRepo.save(new Competence(11,"Communication orale","Capacité à diffuser des messages claires aux interlocuteurs tenant compte de leurs contextes, leurs besoins d'information et leurs niveaux d'abstraction","Suivi Opérationnel : Qualité des échanges et des présentations orales"));
//			competenceRepo.save(new Competence(12,"Communication écrite ","Capacité à rédiger des messages claires aux interlocuteurs tenant compte de leurs contextes, leurs besoins d'information et leurs niveaux d'abstraction","Suivi Opérationnel : Qualité des échanges par écrit"));
//			competenceRepo.save(new Competence(13,"Négociation et persuasion","Capacité à mener des discussions et des négociations dans un climat de respect. ","Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe. KPI projets. - degré de gestion de conflit ( conciliation et consensus)"));
//			competenceRepo.save(new Competence(14,"Prise de parole et conviction","Capacité à faire des présentations orales, à mener des réunions de grande qualité et à être dans la conviction dans le respect de l'autre","Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe. KPI projets."));
//			competenceRepo.save(new Competence(15,"Encadrement et Animation des équipes","capacité à fédérer et à mobiliser les énergies vers une action collective et/ou pour la défense d'un projet commun Capacité à créer de la cohésion via divers moyens tels que les ateliers de réflexions, l' animation de réunions individuelles et collectives, etc…","Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe. KPI projets.: niveau de performance, d'engagement des équipes et degré d'atteinte des objectifs collectifs"));
//			competenceRepo.save(new Competence(16,"Gestion du Client","Capacité à comprendre le marché, les clients et les concurrents. Prise en compte des besoins du client, garantie de sa satisfaction et sa fidélisation.","Appréciation managériale: niveau de satisfaction et fidélisation du client"));
//			competenceRepo.save(new Competence(17,"Gestion de projet","capacité  à mener des projets vers leurs objectifs fixés avec respect des délais et des ressources alloués","Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe.KPI projets."));
//			competenceRepo.save(new Competence(18,"Gestion Budgétaire","Responsabilité financière:  Budget à charge","Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe.KPI projets."));
//			competenceRepo.save(new Competence(19,"Périmètre de responsabilité","Périmètre de responsabilité à charge: Nombre des effectifs gérés, périmètre d'intervention, complexité des sujets affectés","Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe. KPI projets."));
//			competenceRepo.save(new Competence(20,"Business développement","Capacité à identifier les gisements de développement de business, et faire du rebond chez le client  ","Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe.\n KPI projets."));
//			competenceRepo.save(new Competence(21,"Respect et application des règles","Conduite au sein de l'entreprise. Niveau d'Application du règlement interne et de l'incarnation des valeurs de l'entreprise","Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe.KPI projets."));
//			competenceRepo.save(new Competence(22,"Coopération, esprit d'équipe et partage de connaissance","Capacité à travailler en équipe, à développer l'esprit d'équipe, à partager des informations, à mener des actions pour la collectivité","Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe.KPI projets."));
//			competenceRepo.save(new Competence(23,"Capacité d'apprentissage","Le désir et l’aptitude à progresser rapidement et à adapter ses compétences","Suivi Opérationnel : Niveau de performance.Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe.KPI projets."));
//			competenceRepo.save(new Competence(24,"Motivation, Implication & Engagement","Capacité à diffuser de l'enthousiasme, à conserver sa motivation dans les moments de tension","Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe.KPI projets."));
//			competenceRepo.save(new Competence(25,"Agilité et ouverture au changement","Capacité à s'adapter à de nouvelles situations. Attitude face aux changements de contextes au niveau du périmètre individuel, de l'entreprise et de l'environnement de l'entreprise","Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe.KPI projets."));
//			competenceRepo.save(new Competence(26,"Capacité d'Analyse","Capacité à analyser un problème ou une situation, à les comprendre, à proposer différentes solutions documentées et à démontrer leur bien-fondé","Suivi opérationnel: Pertinence des analyses et études réalisées Coding Game ou autres outils de mesure"));
//			competenceRepo.save(new Competence(27,"Pro activité et innovation","Capacité à partager les expériences et les best practices, à contribuer à la  gestion des connaissances","Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe. KPI projets."));
//
//		};
//	}
}
