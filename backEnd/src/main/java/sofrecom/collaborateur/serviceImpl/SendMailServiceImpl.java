package sofrecom.collaborateur.serviceImpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import sofrecom.collaborateur.model.Mail;
import sofrecom.collaborateur.service.SendMailService;

@Service
public class SendMailServiceImpl implements SendMailService {
	private final JavaMailSender javaMailSender;

	public SendMailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public void sendMail(Mail mail) throws MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();
		

		MimeMessageHelper msg = new MimeMessageHelper(message, true);
		msg.setTo(mail.getRecipient());

		msg.setSubject(mail.getSubject());
		msg.setText(mail.getMessage(),true);

		javaMailSender.send(message);
	}

	@Override
	public void sendMailWithAttachments(Mail mail) throws MessagingException {
		MimeMessage msg = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(msg, true);

		helper.setTo("to_@email");

		helper.setSubject("Testing from Spring Boot");

		helper.setText("Find the attached image", true);

		helper.addAttachment("hero.jpg", new ClassPathResource("hero.jpg"));

		javaMailSender.send(msg);
	}

}
