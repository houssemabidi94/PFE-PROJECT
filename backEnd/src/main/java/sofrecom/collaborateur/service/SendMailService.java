package sofrecom.collaborateur.service;
import javax.mail.MessagingException;

import sofrecom.collaborateur.model.Mail;

public interface SendMailService {
    void sendMail(Mail mail) throws MessagingException;

    void sendMailWithAttachments(Mail mail) throws MessagingException;
}
