package module.dev.helper;

import module.dev.exceptions.MailAuthenticationErrorException;
import module.dev.exceptions.MailSendErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailAuthenticationException;
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

    private Logger logger = LoggerFactory.getLogger(MailHelper.class);

    public String prepareMessage(String to, String subject, String body)
            throws MailSendErrorException, MailAuthenticationErrorException {
        List<String> toList = new ArrayList<>();
        toList.add(to);

        return sendSimpleMessage(toList, subject, body);
    }

    public String sendSimpleMessage(List<String> to, String subject, String text)
            throws MailAuthenticationErrorException, MailSendErrorException {
        try {
            logger.info("Sending mail to: " + to.toString());

            message.setTo(to.toArray(new String[0]));
            message.setFrom(from);
            message.setSubject(subject);
            message.setText(text);

            emailSender.send(message);
            return "\nEmail sended successfully!\n";
        } catch (MailAuthenticationException e) {
            throw new MailAuthenticationErrorException(e.getMessage(), message.toString());
        } catch (MailSendException s) {
            throw new MailSendErrorException(s.getMessage(), message.toString());
        }
    }
}
