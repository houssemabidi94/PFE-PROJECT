package sofrecom.collaborateur.serviceImpl;

import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import sofrecom.collaborateur.model.Campagne;
import sofrecom.collaborateur.model.Competence;
import sofrecom.collaborateur.model.DAOUser;
import sofrecom.collaborateur.model.Description;
import sofrecom.collaborateur.model.DescriptionPK;
import sofrecom.collaborateur.model.Entretien;
import sofrecom.collaborateur.model.Fonction;
import sofrecom.collaborateur.model.Niveau;
import sofrecom.collaborateur.model.Objectif;
import sofrecom.collaborateur.repository.CampagneRepository;
import sofrecom.collaborateur.repository.CompetenceRepository;
import sofrecom.collaborateur.repository.DescriptionRepository;
import sofrecom.collaborateur.repository.EntretientRepository;
import sofrecom.collaborateur.repository.FonctionRepository;
import sofrecom.collaborateur.repository.NiveauRepository;
import sofrecom.collaborateur.repository.ObjectifRepository;
import sofrecom.collaborateur.repository.UserRepository;

@Service
public class InitDataBase {

	@Autowired
	CompetenceRepository competenceRepo;

	@Autowired
	NiveauRepository niveauRepo;

	@Autowired
	DescriptionRepository descRepo;

	@Autowired
	FonctionRepository fonctionRepository;

	@Autowired
	CampagneRepository campagneRepository;
	
	@Autowired
	CampagneService campagneServ;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private EntretientRepository entRepo;
	
	@Autowired
	private ObjectifRepository objRepo;
	
	Fonction fonction;
	
	////////
	// Les niveaux du diplome
	List<String> niv_dip = Arrays.asList("Inférieur à Bac + 2", "Technicien ou Licence  ( Bac + 3)",
			"Maitrise ( Bac + 4: Ancien Régime)", "Ingénieur Ou master",
			"Ingénieur Grandes Ecoles à l'internationales/Doctorat/E-MBA");
	// Les niveaux du expérience pro
	List<String> niv_exppro = Arrays.asList("Inférieur à 2 ans ou Inférieur à 1 an à Sofrecom",
			"Entre 2 à 5 ans ou de 1 à 4 ans avec 1 an à Sofrecom",
			"Entre 5 à 8 ans ou de 3 à 6 ans avec 2 ans à Sofrecom",
			"Entre 8 à 12 ans ou de 6 à 10 ans avec 2 ans à Sofrecom",
			"Plus que 12 ans ou plus que 10 ans avec 2 ans à Sofrecom");
	// Les niveaux du formations et certif
	List<String> form_cert = Arrays.asList(
			"Au moins une Formation de niveau Associate (niveau basique) sur une compétences de bases du domaine d'exécution",
			"Une certification de niveau Associate (niveau intermédiaire) sur une compétences de bases du domaine d'exécution",
			"Au moins deux Certifications ou formations de niveau Professionnel (niveau avancé) sur une compétences de bases du domaine d'exécution",
			"Au moins une Certification de niveau Expert sur une compétence de base du domaine d'exécution\n"
					+ "Ou bien plusieurs certifications de Niveau Associate et Professionnelles sur des compétences de bases du domaine d'exécution",
			"Au moins une Certification de niveau Expert sur une compétence pointue ou rare: une technologie, une méthodologie ou des compétences à forte valeur ajoutée pour l'entreprise ou il y a très peu de personnes qui maitrisent et y sont certifiées.");
	// Les niveaux du Connaissances Métiers
	List<String> métiers = Arrays.asList(
			"Dispose des connaissances métier fondamentales requises pour la réalisation de ses travaux dans les règles de l'art ",
			"Maitrise des connaissances fondamentales du métier à l'issue d'une mise en pratique de celles-ci sur des cas de complexité moyenne ",
			"Maitrise avancées des connaissances fondamentales du métier et du SI d'un point de vue fonctionnel l'issue d'une mise en pratique de celles-ci sur des cas complexes.\n"
					+ "Des connaissances variées sur des domaines de compétences connexes",
			"Dispose de connaissances avancées et pointues du métier et du SI d'un point de vue fonctionnel avec une expertise confirmées sur les domaines de compétences principaux.\n"
					+ "Des connaissances variées sur des domaines de compétences connexes",
			"Connaissances avancées et pointues du métier avec une expertise confirmées sur plusieurs domaines fonctionnels de compétences et du SI.\n"
					+ "Des connaissances avancés sur des domaines fonctionnels  de compétences connexes\n"
					+ "Se tient au courant des nouveautés du domaine / Apprentissage en continu / Une veille technologique  ");
	// Les niveaux du Maitrise Technique
	List<String> maitrise = Arrays.asList(
			"Dispose des connaissances fondamentales dans les technologies, les standards et les outils requis pour son poste.",
			"Maitrise des connaissances fondamentales des technologies, des standards et des outils requis pour son poste. Mise en pratique de celles-ci sur des cas de complexité moyenne ",
			"Maitrise avancées des connaissances fondamentales des technologies, des standards et des outils requis pour son poste à l'issue d'une mise en pratique de celles-ci sur des cas complexes.\n"
					+ "Des connaissances variées sur des domaines de compétences connexes",
			"Dispose de connaissances avancées et pointues des technologies, des standards et des outils requis pour son poste  avec une expertise confirmées sur les domaines de compétences principaux.\n"
					+ "Des connaissances variées sur des domaines de compétences connexes",
			"Connaissances avancées et pointues des technologies, des standards et des outils avec une expertise confirmées sur plusieurs domaines de compétences et technologies de pointe.\n"
					+ "Des connaissances avancés sur des domaines de compétences connexes\n"
					+ "Se tient au courant des nouveautés du domaine / Apprentissage en continu / Une veille technologique ");
	// Les niveaux du Performance Opérationnelle
	List<String> perf_oper = Arrays.asList(
			"Besoin d'être accompagné par un mentor pour pouvoir réaliser les travaux demandés dans les règles de l'art  et l'application des normes en vigueur",
			"Réalise les travaux demandés dans les règles de l'art en toute autonomie",
			"Réalise les travaux demandés dans les règles de l'art. Met en œuvre des bonnes pratiques et des moyens permettant d'optimiser l'exécution du travail et l'amélioration de sa qualité.\n"
					+ "Apporte souvent de l'aide et du support à ses collègues pour la réalisation de leurs travaux ",
			"Livre un travail de haute qualité. Innove souvent dans sa façon de faire. Propose et met en œuvre de bonnes pratiques et des astuces  pour optimiser et améliorer la qualité.\n"
					+ "Référent reconnu sur son domaine de compétence au sein de son équipe.",
			"Expert reconnu au delà de son périmètre d'intervention. Référence dans son domaine. Son expertise est considérée comme un levier de développement pour l'entreprise et/ou le client.\n"
					+ "En s'appuyant sur son expertise, il contribue à la définition de la stratégie de développement de l'entreprise");
	// Les niveaux du Estimation et Planification des travaux
	List<String> estim_plan = Arrays.asList(
			"Fait l'estimation de ses travaux, comprend le planning fixé et arrive à le tenir.  avec l'aide d'un mentor.",
			"Fait des estimation fiables de son travail. \n"
					+ "Organise son travail avec méthode et efficacité pour atteindre les objectifs qui  lui sont fixés.",
			"Fait des estimations fiables pour des lots de travail de moyenne taille (l'équivalent d'un backlog d'un srprint pour une feature team de 7 personnes).\n"
					+ "Développe des plannings réalistes et optimisés\n"
					+ "Connaissances basiques des outils et techniques d'estimation et planifications",
			"Fait des estimation fiables pour des projets et des travaux complexes (L'équivalent d'un backlog d'un projet moyen ~ 60 hommes-mois).\n"
					+ "Développe des plannings réalistes et optimisés avec prise en considération des risques et des imprévus\n"
					+ "Maitrise des outils et techniques d'estimation et planifications",
			"Planification stratégique, sur le long terme. Fait des estimations à large échelle: multi projets, multi équipe.\n"
					+ "Développe des plannings Complexes et optimisés avec prise en considération des risques et des imprévus.\n"
					+ "Maitrise des outils et technique d'estimation et de planifications avancés");
	
	// Les niveaux du Gestion du temps et des priorités
	List<String> gestion_tmp = Arrays.asList("Gère bien son temps. Livre ses travaux à temps. Alerte son responsable opérationnel suffisamment à l'avance en cas de risque de débordement.",
			"Gère bien son temps en étant sur plusieurs tâches en parallèles. Arrive à prioriser ses tâches en coordination avec son responsable opérationnel et les partie impactée par cette priorisation",
			"Garant de respect des délai pour une équipe ou bien projet de complexité moyenne. Gère bien les priorités, anticipe et mesure les risques .",
			"Pilote l'avancement de travaux pour plusieurs équipes ou projets/Programme complexes. Met en place des outils de suivi des avancements. Anticipe les risques et met en place des plans d'actions.",
			"Pilote l'avancement de chantiers stratégiques à long terme et garantie le respect des délais.");
	
	// Les niveaux du Qualité
	List<String> qualite = Arrays.asList("Applique les règles de qualité et les bonnes pratiques pour la réalisation de ses travaux ",
			"Maitrise des règles de qualité et des bonnes pratiques en vigueur. Fait de propositions pour l'amélioration de la qualité des livrables.",
			"Garant de la qualité des livrables d'une équipes ou d'un projet. Instaure la culture qualité et fait le contrôle de la qualité des livrables.",
			"Bonnes connaissance des normes qualité en vigueur. Maitrise les processus qualités de l'entreprise et/ou du client applicables et veille la bonne application de celle-ci. Fait des propositions d'amélioration du référentiel qualité.",
			"Référent de la gestion qualité. Maitrise du référentiel Qualité de l'entreprise et contribution à sa mise à jour.");
	
	// Les niveaux du Méthodologie rédactionnelle
	List<String> met_redac = Arrays.asList("Rédige des documents simples et claires",
			"Rédige des documents claires et complets sur des thématiques complexes. Maitrise les outils et les techniques documentaires Porte une attention à la forme et l'ergonomie des documents livrés",
			"Produit des documents de haute qualité avec un contenu riches et exhaustive et une ergonomie bien soignées. Il y a rarement des erreurs ou bien des retours sur ce qu'il produit.\r\n"
			+ "Synthétise, de manière condensée et objective, le contenu des informations",
			"Maitrise la liste des document à produire et les modèles et technique à utiliser sur chaque type de document. Accompagne l'équipe à livrer des documents conformes en faisant des relectures et diffusion les bonnes pratiques.\r\n"
			+ "Produit, en temps limité, des écrits clairs, fluides et pertinents : argumentaire, note interne, compte rendu, e-mail, contenu de site Internet, écrit délicat",
			"Maitrise parfaitement la langue et détient un style rédactionnel distingué.\r\n"
			+ "Rédige ses textes du point de vue du destinataire pour influencer et créer une relation de confiance. \r\n"
			+ "Rédige des documents structurés qui seront lus rapidement et compris facilement pouvant être utilisés de référence / de documentation à l'échelle entreprise.");
	
	// Les niveaux du Communication orale
	List<String> comm_orale = Arrays.asList("Exprime ses idées et opinions avec clarté et précision. \r\n"
			+ "Utilise son vocabulaire d'une manière souple et efficace pour des relations sociales ou professionnelles.",
			"Peut expliquer d'une façon simple, synthétique et structurée des sujets relativement complexe face à un client ou un collègue",
			"Conscient des besoins d'information de chaque partie prenante et adapte son discours selon la situation et l'interlocuteur. À l'aise avec la communication à distance ou face à un publique",
			"S'exprime spontanément et couramment sans chercher ses mots, en situations d'improvisation, sur des sujets complexes et inconnus.",
			"Capacité à inscrire sa communication dans la stratégie et à donner du sens.  favorise la transversalité. diffuse la culture du Groupe et les enjeux managériaux, développe le sentiment d’appartenance");
	
	// Les niveaux du Communication écrite 
	List<String> comm_ecrite = Arrays.asList("Rédige des notes et des textes simples, compréhensibles et cohérents.\r\n"
			+ "Maitrise les règles de l'écrit.\r\n"
			+ "Les mails sont clairs et explicites.",
			"Exprime son point de vue dans un texte ou un rapport clair et détaillé. \r\n"
			+ "Le vocabulaire est précis et riche.\r\n"
			+ "La grammaire et l'orthographe sont maîtrisées.",
			"Rédige avec clarté et logique sur divers sujets. Rédige des textes linguistiquement riches . Soigne la forme de ses textes et maitrise leurs ergonomies.",
			"Rend compte par écrit sur des situations complexes (rapports longs et élaborés).",
			"Conscient des besoins d'information de chacun et adapte ses messages et son style selon la situation et l'interlocuteur.");
	
	// Les niveaux du Négociation et persuasion
	List<String> neg_prest = Arrays.asList("Capable de faire des présentations orales  de qualité, à tenir compte de ses interlocuteurs pour adapter sa communication.",
			"L'écoute est active (signes d'approbations, reformulation, questions ouvertes,…). Rebondit avec des arguments forts, logiques.",
			"Capacité à la négociation et à la persuasion dans le respect de l'autre, \r\n"
			+ "Montre un esprit positif et une force de proposition constructive.",
			"Met le non verbal au service de la communication (le corps et le message sont en totale harmonie). \r\n"
			+ "Fait preuve de patience nécessaire pour écouter les autres jusqu'au bout. \r\n"
			+ "Avance des arguments en se basant sur du factuel.\r\n"
			+ "S'affirme dans le respect de l'autre et dans la recherche de conciliation.",
			"S'exprime à partir d'un plan et d' objectifs SMART\r\n"
			+ "Bonne analyse comportementale et profilage , adapte son discours ,comprend l'idée intrinsèque de son interlocuteur et la met en avant pour obtenir son adhésion. \r\n"
			+ "Entre dans la négociation en essayant de trouver un accord gagnant-gagnant.");
	
	// Les niveaux du Prise de parole et conviction
	List<String> prise_par = Arrays.asList("Maitrise bien ses activités, explique bien ce qu'il est en train de faire en donnant une visibilité  claire de l'état de son avancement.",
			"Participe activement aux réunions et échanges. Fait des propositions claires et pertinentes. Arrive à convaincre de ses idées avec des arguments valides dans le respect de l'autrui.",
			"Fait le cadrage et la définition des objectifs de la réunion. \r\n"
			+ "Anime des réunions avec différents publics en favorisant l'échange. \r\n"
			+ "Avance ses idées face à un public dans un ordre logique et cohérent.",
			"Analyse au préalable le contexte, le thème, le but, les objectifs et les contraintes.\r\n"
			+ "Canalise les échanges entre les profils difficiles.\r\n"
			+ "Rédige un compte rendu exhaustif et compréhensible par tous.",
			"S'approprie la méthodologie qui convient à chaque type de réunion. \r\n"
			+ "Conclut, valide et formalise les points clés.\r\n"
			+ "Prend le leadership des échanges et s'assure que les solutions sont trouvées dans le respect de tous.");
	
	// Les niveaux du Encadrement et Animation des équipes
	List<String> encad_anim = Arrays.asList("Influence positivement le collectif et joue un rôle important à l'instauration  d'un environnement de travail sain et stimulant",
			"\r\n"
			+ "Est attentif aux comportements de l'équipe et Identifie son besoin , repère et anticipe les signes précurseurs de démotivation",
			"Développe la motivation et la performance de l'équipe. Inspire ses équipes et les accompagne pour l'atteinte de leurs objectifs individuels et collectifs.\r\n"
			+ "Ajuste son comportement à la personnalité de chacun.",
			"Pratique un management de la reconnaissance. \r\n"
			+ "Met en place des plans d'actions managériaux pour répondre aux besoins identifiés chez ses collaborateurs. \r\n"
			+ "Maîtrise les techniques de coaching d'équipe",
			"Ajuste son leadership aux profils des collaborateurs et des situations.\r\n"
			+ "Reconnait  ses erreurs.\r\n"
			+ "Se montre cohérent et donne l'exemple. \r\n"
			+ "Maintient un équilibre entre la discipline et la flexibilité.");
	
	// Les niveaux du Gestion du Client
	List<String> gestion_client = Arrays.asList("Prend en compte les besoins du client et livre un Produit / Service conforme à ses attentes",
			"Tourné vers le client. Vise en continu à augmenter la satisfaction du client et l'amélioration du service/produit rendu conformément à ses attentes notifiées",
			"Maintient une relation de confiance avec le client. S'investit pendant les crises pour apporter des solutions efficaces",
			"Gère des clients exigeants avec des besoins complexes. Garantie leur satisfaction et assure leurs fidélités  toute en garantissant les enjeux business de l'entreprise",
			"Un vrai ambassadeur et porteur de l'image de l'entreprise auprès des clients. Joue un rôle important à la fidélisation du client actuel et l'attraction de nouveaux clients");
	
	// Les niveaux du Gestion de projet
		List<String> gestion_projet = Arrays.asList("Initié à la gestion de projet. Aide le chef de projet à bien mener son projet. Géré des parties du projet par délégation",
				"Gère des projets simples avec des budgets et des ressources limités",
				"Géré des projets complexe avec des enjeu importants et des budgets importants.\r\n"
				+ "Maitrise les outils et les technique de gestion de projet.",
				"Gère des programmes moyennement complexes embarquant plusieurs projets\r\n"
				+ "Maitrise les outils et les technique de gestion de programmes",
				"Gère des programmes complexes embarquant plusieurs projets de taille importante et avec un grand impact sur la stratégie de développement de l'entreprise.");
	
		
		// Les niveaux du Gestion Budgétaire
		List<String> gestion_budget = Arrays.asList("Responsabilité au niveau individuel. Garant sur le respect du budget  (en Jour homme) de ses activités et de ses imputations./ Chiffrage",
				"Responsabilité sur un budget moyen  (en Jour homme) pour un projet",
				"Responsabilité sur un budget moyen  (en Jour homme et/ ou en euros) pour un portefeuille de projet",
				"Responsabilité sur un budget important  (en Jour homme et en euros) pour un portefeuille de projet ou un programme niveau entreprise",
				"Responsabilité sur un budget important  (en Jour homme et en euros) pour un portefeuille de projet ou un programme niveau corporate");
		
		// Les niveaux du Périmètre de responsabilité
		List<String> perim_resp = Arrays.asList("Responsabilité au niveau individuel. Garant de livraison de ses travaux sur un périmètre réduit",
				"Responsable d'une équipe  de taille moyenne (7/14 collaborateurs),  un Projet simple et/ou un Domaine Technique/Fonctionnel relativement large.\r\n"
				+ "Ou poste avec un impacte moyen sur l'entreprise, mangement transversal sur un périmètre de plus que 100 personnes.",
				"Responsable d'une équipe  de taille moyenne (15/25 collaborateurs),  un Projet complexe et/ou transverse sur plusieurs Domaines Technique/Fonctionnel.\r\n"
				+ "Ou poste avec un impacte important sur l'entreprise, mangement transversal sur un périmètre de plus que 300 personnes.",
				"Responsable d'une entité (26/70 collaborateurs) avec plusieurs équipes, un Programme complexe et/ou Expertise confirmé sur plusieurs Domaines Technique/Fonctionnel.\r\n"
				+ "Ou poste avec un impacte très important sur l'entreprise, mangement transversal sur un périmètre de plus que 500 personnes",
				"Responsable d'une structure complexe - Top Manager.\r\n"
				+ "Poste très critique pour les enjeux stratégique et financiers de l'entreprise, impacte sur toute l'entreprise.");
		
		// Les niveaux du Business développement
		List<String> business_dev = Arrays.asList("Fidélise son client directe et sécurise le business du périmètre sous sa responsabilité",
				"Détecte les opportunités de développement du business avec le client en face et le convainc d'élargir ses activités avec Sofrecom",
				"Ramènes de nouveaux business pour l'entreprises et participe à l'augmentation de ses gains et son CA ",
				"Anticipe les opportunités et prépare le terrain pouvoir positionner l'entreprise sur des marchés prometteurs.",
				"Met en place les plans stratégiques et les axes de développement de l'entreprise.");
		
		// Les niveaux du Respect et application des règles
		List<String> respect = Arrays.asList("Comportement professionnel au sein de l'entreprise. Respect des règles de bonne conduite et de gouvernance.",
				"Montre un sens d'appartenance à l'entreprise.  Maitrise la réglementation interne. Donne de l'exemple à ses collègues.",
				"Porte un intérêt à préserver le climat social et les biens mis à disposition  au sein de l'entreprise ",
				"Comportement exemplaire. S'approprie les valeurs de l'entreprise et les diffuse dans son entourage.",
				"Un vrai ambassadeur  des valeurs de l'entreprise à l'intérieur et à l'extérieur.");
		
		// Les niveaux du Coopération, esprit d'équipe et partage de connaissance
		List<String> cooperation = Arrays.asList("Communique bien au sein de son équipe et coopère avec ses collègue pour l'atteinte des objectifs collectifs",
				"Prédisposé à aider ses collègues, pense à l'intérêt commun.",
				"Facilite les échanges et le partage au sein de l'équipe et participe à la création du collectif. A été le mentor d'un nouveau membre de l'équipe ou a encadré un stagiaire pour son stage de fin d'étude.",
				"Favorise le partage et l'entre-aide au-delà de son équipe. Participe  à des chantiers transverses. Encadrement des seniors dans l'équipe, fait des sessions de partage.",
				"Très coopératif et tourné vers l'autre. Développe le partage favorise l'entre-aide au sein de l'entreprise. Connu par l'encadrement des seniors dans l'entreprise, fait des sessions de partage ou des formations internes.");
		
		// Les niveaux du Capacité d'apprentissage
		List<String> cap_app = Arrays.asList("Assimile facilement les informations et les instructions reçues sur son périmètre d'activité",
				"Cherche en continue à développer ses connaissances et ses compétences. Met en pratique ce qu'il apprends facilement",
				"Capitalise sur les savoirs reçus et les expériences vécus. Participe à enrichir les base de connaissances de l'équipe",
				"Curiosité culturelle accrue. En apprentissage continue sur différents sujets que ce soit sur son domaine d'activité ou en dehors de celui-ci. Met ses connaissance à disposition de l'entreprise.",
				" Participe activement à l'enrichissement de la base de connaissance de l'entreprise. Propose et met en place les méthodes et les outils permettant la capitalisation des savoirs de l'entreprise.");
	
		// Les niveaux du Motivation, Implication & Engagement
		List<String> mie = Arrays.asList("Fait preuve d'implication dans ses taches et dans son projet. Très motivé pendant la réalisation de ses activités.",
				" Capacité à conserver sa motivation dans les moments de tension. Se rend disponible lorsque nécessaire pour compenser une surcharge de travail ou compléter des travaux urgents et prioritaires.",
				"Capacité à diffuser de l'enthousiasme au sein de l'équipe. Se soucie de l'intérêt de l'équipe et de l'entreprise et de l'image qu'on en donne.",
				"S'investi pour maintenir le niveau de motivation et d'implication de l'équipe. Met en place les bonnes pratiques d'hygiène collective.",
				" En mesure de comprendre les motivations des personnes avec lesquelles il travaille afin de les mettre au service du projet de l'entreprise. Met ses propres compétences et savoirs-être au service des autres.");
		
		// Les niveaux du Agilité et ouverture au changement
		List<String> agilite = Arrays.asList("Accepte le changement. Demande de l'aide pour pouvoir s'y adapter.",
				"Manifeste une attitude positives face aux changements. Capable de mesurer l'impacte de changement sur son activité et de prendre les actions nécessaire pour s'y adapter",
				"Un état d'esprit\r\n"
				+ " Agile. Aisance dans des contextes volatiles. S'adapte en continue au changement.",
				"Conduit les changements et aide l'organisation à leurs mise en place. Accompagne les équipes pour s'adapter au changement en minimisant les impactes",
				"Aide l'entreprise à développer son agilité et à dynamiser son organisation. Réactivité face à des imprévue, prend les bonnes mesures et suit leurs mise en place.");
		
		// Les niveaux du Capacité d'Analyse
		List<String> analyse = Arrays.asList("Analyse pertinemment des situations et des problèmes relativement moyens\r\n"
				+ " ( équivalent à des problémes mathématiques et algorathmiques académiques) et contribue à identifier des solutions pertinentes et valides.",
				"Analyse pertinemment des situations et des problèmes réels complexes ( des problèmes mathématiques et algorithmiques / logiques liés à son périmètre d'intervention) et contribue à identifier des solutions pertinentes et valides.",
				"Structure efficacement son travail de recherche, et maitrise les sources d’information à solliciter. Capable de décomposer des problèmes et des situations à fin de diviser leurs complexités. \r\n"
				+ "Propose les solutions possibles en précisant les risques et la complexité de chacune. ",
				"Prend des démarches très méthodiques et maitrise plusieurs techniques d'analyse de problèmes. Dégage les solutions potentielles et identifie la plus optimisée et la moins risquée parmi celles-ci.",
				"Capable d'analyser et des problèmes à large échelle qui couvre plusieurs périmètres. Pilote des chantiers d'étude, répartie les activité et consolide les résultats. Référent sur les sujets les plus complexe.");
		
		// Les niveaux du Pro activité et innovation
		List<String> pai = Arrays.asList("Utilise les bonnes méthodes dans l'exercice de ses activités. Identifie en continue les manques et met en place les actions nécessaires pour les régler",
				"Se tient informé des nouveautés techniques et des nouvelles bonnes pratiques et saisie les occasions pour les mettre en application au niveau de ses activités",
				"Analyse et évalue les situations afin d'identifier les opportunités de développement de façon proactive. Perçoit le sens global et utilise des idées novatrices dans ses activités.",
				"Prévoit et aborde les problèmes et les questions de façon constante et persévérante.  Propose des améliorations et des techniques qui peuvent augmenter la productivité ou l'efficacité.\r\n"
				+ "Fait partie d'un cercle d'expertise groupe comme Orange Expert, Crafteurs, Architecte réfèrent, etc.",
				"Fait preuve de flexibilité, d'originalité et de remise en question. Il est dans une dynamique d'amélioration continue et fait émerger des idées innovantes. Fait partie à plusieurs communauté d'expertise groupe et joue un rôle d'animateur ou ilote sur une communauté en local ou niveau groupe.");
		
		/////////////////////////////////
//niveaux List
	List<String> niveaux = Arrays.asList("Niveau 1", "Niveau 2", "Niveau 3", "Niveau 4", "Niveau 5");

	@Bean
	InitializingBean InitDB() {
		return () -> {


			
			// init Fonction
			fonctionRepository.save(new Fonction(1, "collaborateur"));
			fonctionRepository.save(new Fonction(2, "manager"));
			fonctionRepository.save(new Fonction(3, "directeur"));
			
			//create users
			
			//Manager
			
			DAOUser newUser = new DAOUser();
			newUser.setId(1);
			newUser.setFullname("Ammar Missaoui");
			newUser.setEmail("houcemabidi2018@gmail.com");
			newUser.setUsername("ammar_missaoui");
			newUser.setPassword(bcryptEncoder.encode("manager"));
			newUser.setMatricule("SOF-1234");
			newUser.setDateIntegration(new Date(System.currentTimeMillis()));
			newUser.setFonction(new Fonction(2));
			userRepo.save(newUser);
			
			//Collab
			
			DAOUser newUser2 = new DAOUser();
			newUser2.setId(2);
			newUser2.setFullname("Houssem Abidi");
			newUser2.setEmail("houssem19942010@hotmail.com");
			newUser2.setUsername("houssem_abid");
			newUser2.setPassword(bcryptEncoder.encode("collab"));
			newUser2.setMatricule("SOF-1234");
			newUser2.setDateIntegration(new Date(System.currentTimeMillis()));
			newUser2.setFonction(new Fonction(1));
			newUser2.setManager(newUser);
			userRepo.save(newUser2);
			
			//collab 2
			
			DAOUser newUser3 = new DAOUser();
			newUser3.setId(3);
			newUser3.setFullname("collab2");
			newUser3.setEmail("collab2");
			newUser3.setUsername("collab2");
			newUser3.setPassword(bcryptEncoder.encode("collab2"));
			newUser3.setMatricule("SOF-1234");
			newUser3.setDateIntegration(new Date(System.currentTimeMillis()));
			newUser3.setFonction(new Fonction(1));
			newUser3.setManager(newUser);
			userRepo.save(newUser3);
			
			// init compagne
			campagneRepository.updateActifStatus();
			campagneRepository.save(new Campagne(campagneServ.getPreviousSemester(), false));
			campagneRepository.save(new Campagne(campagneServ.getSemesterAndYear(), true));
			campagneRepository.save(new Campagne(campagneServ.getNextSemester(), false));

			// init entretient
			entRepo.save(new Entretien(1,newUser, new Campagne(campagneServ.getPreviousSemester())));
			entRepo.save(new Entretien(2,newUser2, new Campagne(campagneServ.getPreviousSemester())));
			entRepo.save(new Entretien(3,newUser3, new Campagne(campagneServ.getPreviousSemester())));
			entRepo.save(new Entretien(4,newUser, new Campagne(campagneServ.getSemesterAndYear())));
			entRepo.save(new Entretien(5,newUser2, new Campagne(campagneServ.getSemesterAndYear())));
			entRepo.save(new Entretien(6,newUser3, new Campagne(campagneServ.getSemesterAndYear())));
			//init obj
for(long i=1 ; i<17;i++) {
			objRepo.save(new Objectif(i,"obj"+i, new Entretien(1)));
			i++;
			objRepo.save(new Objectif(i,"obj"+i, new Entretien(2)));
			i++;
			objRepo.save(new Objectif(i,"obj"+i, new Entretien(3)));
}
			
			// init competence
			competenceRepo.save(new Competence(1, "Diplôme", "Plus haute qualification universitaire Obtenue",
					"Documents fournis à l'embauche"));
			competenceRepo.save(new Competence(2, "Expérience Professionnelle", "Niveau de séniorité dans le métier",
					"Fourni par la RH"));
			competenceRepo.save(new Competence(3, "Formations et Certifications",
					"Formations et certifications Réalisées dehors en du cursus universitaire",
					"Documents fournis à l'embauche + Formations suivies et certifications obtenues à Sofrecom  Sofrecom"));
			competenceRepo.save(new Competence(4, "Connaissances Métiers",
					"Niveaux des Connaissances et des savoirs Acquis. Pertinence du parcours professionnel et Académique",
					"Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe."));
			competenceRepo.save(new Competence(5, "Maitrise Technique",
					"Niveau de maitrise de son domaine technique de compétence. En veille sur son domaine.",
					"Suivi Opérationnel : Niveau de performance Coding Game ou autres outils de mesure.Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe"));
			competenceRepo.save(new Competence(6, "Performance Opérationnelle",
					"Capacité à développer et à mettre en pratique ses connaissances, à utiliser celles-ci pour proposer des approches appropriées aux problématiques rencontrées.",
					"Suivi Opérationnel : Niveau de performance.Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe.KPI projets."));
			competenceRepo.save(new Competence(7, "Estimation et Planification des  travaux ",
					"Capacité à estimer et à planifier des travaux individuels et collectifs",
					"Suivi Opérationnel : Niveau de performance.Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe.KPI projets"));
			competenceRepo.save(new Competence(8, "Gestion du temps et des priorités",
					"Capacité à bien exploiter le temps à disposition pour réaliser les travaux en charge et à prioriser les sujets selon leurs importances et urgences",
					"Suivi Opérationnel : Niveau de performance.Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe.KPI projets."));
			competenceRepo.save(new Competence(9, "Qualité",
					"Capacité à produire les livrables dans le respect des objectifs qualité de Sofrecom ",
					"Suivi Opérationnel : Qualité des livrables"));
			competenceRepo.save(new Competence(10, "Méthodologie rédactionnelle",
					"Capacité à rédiger des documents complets,  claires et percutants et à rendre aux écrits leur rôle stratégique et tactique dans un contexte professionnel",
					"Suivi Opérationnel : Niveau de Qualité des documents produits"));
			competenceRepo.save(new Competence(11, "Communication orale",
					"Capacité à diffuser des messages claires aux interlocuteurs tenant compte de leurs contextes, leurs besoins d'information et leurs niveaux d'abstraction",
					"Suivi Opérationnel : Qualité des échanges et des présentations orales"));
			competenceRepo.save(new Competence(12, "Communication écrite ",
					"Capacité à rédiger des messages claires aux interlocuteurs tenant compte de leurs contextes, leurs besoins d'information et leurs niveaux d'abstraction",
					"Suivi Opérationnel : Qualité des échanges par écrit"));
			competenceRepo.save(new Competence(13, "Négociation et persuasion",
					"Capacité à mener des discussions et des négociations dans un climat de respect. ",
					"Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe. KPI projets. - degré de gestion de conflit ( conciliation et consensus)"));
			competenceRepo.save(new Competence(14, "Prise de parole et conviction",
					"Capacité à faire des présentations orales, à mener des réunions de grande qualité et à être dans la conviction dans le respect de l'autre",
					"Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe. KPI projets."));
			competenceRepo.save(new Competence(15, "Encadrement et Animation des équipes",
					"capacité à fédérer et à mobiliser les énergies vers une action collective et/ou pour la défense d'un projet commun Capacité à créer de la cohésion via divers moyens tels que les ateliers de réflexions, l' animation de réunions individuelles et collectives, etc…",
					"Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe. KPI projets.: niveau de performance, d'engagement des équipes et degré d'atteinte des objectifs collectifs"));
			competenceRepo.save(new Competence(16, "Gestion du Client",
					"Capacité à comprendre le marché, les clients et les concurrents. Prise en compte des besoins du client, garantie de sa satisfaction et sa fidélisation.",
					"Appréciation managériale: niveau de satisfaction et fidélisation du client"));
			competenceRepo.save(new Competence(17, "Gestion de projet",
					"capacité  à mener des projets vers leurs objectifs fixés avec respect des délais et des ressources alloués",
					"Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe.KPI projets."));
			competenceRepo.save(new Competence(18, "Gestion Budgétaire", "Responsabilité financière:  Budget à charge",
					"Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe.KPI projets."));
			competenceRepo.save(new Competence(19, "Périmètre de responsabilité",
					"Périmètre de responsabilité à charge: Nombre des effectifs gérés, périmètre d'intervention, complexité des sujets affectés",
					"Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe. KPI projets."));
			competenceRepo.save(new Competence(20, "Business développement",
					"Capacité à identifier les gisements de développement de business, et faire du rebond chez le client  ",
					"Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe.\n KPI projets."));
			competenceRepo.save(new Competence(21, "Respect et application des règles",
					"Conduite au sein de l'entreprise. Niveau d'Application du règlement interne et de l'incarnation des valeurs de l'entreprise",
					"Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe.KPI projets."));
			competenceRepo.save(new Competence(22, "Coopération, esprit d'équipe et partage de connaissance",
					"Capacité à travailler en équipe, à développer l'esprit d'équipe, à partager des informations, à mener des actions pour la collectivité",
					"Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe.KPI projets."));
			competenceRepo.save(new Competence(23, "Capacité d'apprentissage",
					"Le désir et l’aptitude à progresser rapidement et à adapter ses compétences",
					"Suivi Opérationnel : Niveau de performance.Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe.KPI projets."));
			competenceRepo.save(new Competence(24, "Motivation, Implication & Engagement",
					"Capacité à diffuser de l'enthousiasme, à conserver sa motivation dans les moments de tension",
					"Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe.KPI projets."));
			competenceRepo.save(new Competence(25, "Agilité et ouverture au changement",
					"Capacité à s'adapter à de nouvelles situations. Attitude face aux changements de contextes au niveau du périmètre individuel, de l'entreprise et de l'environnement de l'entreprise",
					"Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe.KPI projets."));
			competenceRepo.save(new Competence(26, "Capacité d'Analyse",
					"Capacité à analyser un problème ou une situation, à les comprendre, à proposer différentes solutions documentées et à démontrer leur bien-fondé",
					"Suivi opérationnel: Pertinence des analyses et études réalisées Coding Game ou autres outils de mesure"));
			competenceRepo.save(new Competence(27, "Pro activité et innovation",
					"Capacité à partager les expériences et les best practices, à contribuer à la  gestion des connaissances",
					"Évaluation Managériale à travers les entretiens techniques et RH, les retours notifiés ou/et mesurés clients ou/et la reconnaissance notifiée de l'équipe. KPI projets."));

			// init niveaux and Descriptions
			for (int i = 0; i < niveaux.size(); i++) {

				// init niveaux
				niveauRepo.save(new Niveau(i + 1, niveaux.get(i)));

				// Descriptions init
				descRepo.save(new Description(new DescriptionPK(1, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), niv_dip.get(i)));
				descRepo.save(new Description(new DescriptionPK(2, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), niv_exppro.get(i)));
				descRepo.save(new Description(new DescriptionPK(3, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), form_cert.get(i)));
				descRepo.save(new Description(new DescriptionPK(4, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), métiers.get(i)));
				descRepo.save(new Description(new DescriptionPK(5, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), maitrise.get(i)));
				descRepo.save(new Description(new DescriptionPK(6, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), perf_oper.get(i)));
				descRepo.save(new Description(new DescriptionPK(7, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), estim_plan.get(i)));
				descRepo.save(new Description(new DescriptionPK(8, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), gestion_tmp.get(i)));
				descRepo.save(new Description(new DescriptionPK(9, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), qualite.get(i)));
				descRepo.save(new Description(new DescriptionPK(10, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), met_redac.get(i)));
				descRepo.save(new Description(new DescriptionPK(11, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), comm_orale.get(i)));
				descRepo.save(new Description(new DescriptionPK(12, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), comm_ecrite.get(i)));
				descRepo.save(new Description(new DescriptionPK(13, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), neg_prest.get(i)));
				descRepo.save(new Description(new DescriptionPK(14, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), prise_par.get(i)));
				descRepo.save(new Description(new DescriptionPK(15, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), encad_anim.get(i)));
				descRepo.save(new Description(new DescriptionPK(16, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), gestion_client.get(i)));
				descRepo.save(new Description(new DescriptionPK(17, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), gestion_projet.get(i)));
				descRepo.save(new Description(new DescriptionPK(18, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), gestion_budget.get(i)));
				descRepo.save(new Description(new DescriptionPK(19, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), perim_resp.get(i)));
				descRepo.save(new Description(new DescriptionPK(20, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), perim_resp.get(i)));
				descRepo.save(new Description(new DescriptionPK(21, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), respect.get(i)));
				descRepo.save(new Description(new DescriptionPK(22, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), cooperation.get(i)));
				descRepo.save(new Description(new DescriptionPK(23, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), cap_app.get(i)));
				descRepo.save(new Description(new DescriptionPK(24, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), mie.get(i)));
				descRepo.save(new Description(new DescriptionPK(25, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), agilite.get(i)));
				descRepo.save(new Description(new DescriptionPK(26, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), analyse.get(i)));
				descRepo.save(new Description(new DescriptionPK(27, i + 1), competenceRepo.findByIdCompetence(i + 1),
						niveauRepo.findByIdNiv(i + 1), pai.get(i)));
			}
		};
	}

}
