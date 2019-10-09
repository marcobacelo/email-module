package module.dev.helper;

import module.dev.exceptions.SmtpException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.MailAuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    public String prepareMessage(String to, String subject, String body) throws SmtpException {
        List<String> toList = new ArrayList<>();
        toList.add(to);

        sendSimpleMessage(toList, subject, body);

        throw new
    }

    public void sendSimpleMessage(List<String> to, String subject, String text) throws SmtpException {

        try {
            logger.info("Sending mail to: " + to.toString());

            message.setTo(to.toArray(new String[0]));
            message.setFrom(from);
            message.setSubject(subject);
            message.setText(text);

            emailSender.send(message);
        } catch (MailAuthenticationException e) {
            System.out.println("Falha de autenticação com o SMTP !!!");
            throw new SmtpException(message.toString());
        } catch (MailSendException s) {
            System.out.println("\nEndereço de email inválido !!!\n");
            throw new SmtpException(message.toString());
        }
    }
}
