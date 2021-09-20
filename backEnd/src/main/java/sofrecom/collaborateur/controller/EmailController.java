package sofrecom.collaborateur.controller;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sofrecom.collaborateur.model.DAOUser;
import sofrecom.collaborateur.model.Mail;
import sofrecom.collaborateur.repository.UserRepository;
import sofrecom.collaborateur.service.SendMailService;
import sofrecom.collaborateur.serviceImpl.CampagneService;
import sofrecom.collaborateur.serviceImpl.UserService;

@RestController
public class EmailController {
	@Autowired
    SendMailService service;
    
	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	CampagneService cs;
	
    public EmailController(SendMailService service) {
        this.service = service;
    }

    @PostMapping("/attachment")
    public ResponseEntity<String> sendAttachmentEmail(@RequestBody Mail mail) throws MessagingException {
        service.sendMailWithAttachments(mail);
        return new ResponseEntity<>("Attachment mail sent successfully", HttpStatus.OK);
    }
	@GetMapping("/mailtomanager")
	public ResponseEntity<String> getManagerMail(HttpServletRequest request) throws MessagingException {
		

		long userId = userService.getCurrentUserId(request);

		String mailmanager = userRepo.getManagerMailByUserId(userId);
		String username = userRepo.getUserFullname(userId);
		
		Mail mail = new Mail();
		mail.setRecipient(mailmanager);
		mail.setSubject("Evaluation");
		mail.setMessage("Bonjour,<p>"
				+ "Le collaborateur <b><u>"+username +"</u></b> a bien fait sa auto-évaluation de ses objectifs pour la semestre <b><u>"+cs.getPreviousSemester()+"</u></b></p>"
				+"<p>Pour voir le rapport de sa évaluation : http://localhost:4200/rapport-collab/"+userId+"</p>");
		
		service.sendMail(mail);
		System.out.println("Email Sent successfully");
		return new ResponseEntity<>("Email Sent successfully", HttpStatus.OK);
	}
	@GetMapping("/mailtocollab/{userId}")
	public ResponseEntity<String> getCollabMail(@PathVariable("userId") long userId) throws MessagingException {
		

		String mailcollab = userRepo.getUserMail(userId);
		DAOUser manager = userRepo.getManagerByUserId(userId);
		
		Mail mail = new Mail();
		mail.setRecipient(mailcollab);
		mail.setSubject("EIPs");
		mail.setMessage("Bonjour,<p>"
				+ "Le manager <b><u>"+manager.getFullname() +"</u></b> a bien fait l'entretien individuel professionel pour la semestre <b><u>"+cs.getPreviousSemester()+"</u></b></p>"
				+"<p>Pour voir le rapport de l'eip : http://localhost:4200/rapport-manager</p>");
		
		service.sendMail(mail);
		System.out.println("Email Sent successfully");
		return new ResponseEntity<>("Email Sent successfully", HttpStatus.OK);
	}
}

