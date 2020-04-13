package module.dev.helper;

import module.dev.DAO.MailDAO;
import module.dev.exceptions.MailAuthenticationErrorException;
import module.dev.exceptions.MailParseErrorException;
import module.dev.exceptions.MailSendErrorException;
import module.dev.model.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailParseException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailHelper {

    SimpleMailMessage message = new SimpleMailMessage();

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private MailDAO mailDAO;

    private Logger logger = LoggerFactory.getLogger(MailHelper.class);

    public String prepareMessage(String to, String subject, String body)
            throws MailSendErrorException, MailAuthenticationErrorException, MailParseErrorException {
        List<String> toList = new ArrayList<>();
        toList.add(to);

        return sendSimpleMessage(toList, subject, body);
    }

    public String sendSimpleMessage(List<String> to, String subject, String text)
            throws MailAuthenticationErrorException, MailSendErrorException, MailParseErrorException {
        try {
            logger.info("Sending mail to: " + to.toString());

            message.setFrom(from);
            message.setTo(to.toArray(new String[0]));
            message.setSubject(subject);
            message.setText(text);

            emailSender.send(message);
            Email email = new Email();
            email.setSubject(subject);
            email.setAddress(to.get(0));
            email.setBody(text);
            mailDAO.save(email);

            return "\nEmail sended successfully!\n";

        } catch (MailAuthenticationException e) {
            throw new MailAuthenticationErrorException(e.getMessage(), message.toString());
        } catch (MailSendException s) {
            throw new MailSendErrorException(s.getMessage(), message.toString());
        } catch (MailParseException p) {
            throw new MailParseErrorException(p.getMessage(), message.toString());
        }
    }
}
