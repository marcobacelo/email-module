package module.dev.helper;

import module.dev.model.Email;
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

    public String sendSimpleMessage(String to, String subject, String body) {
        List<String> toList = new ArrayList<>();
        toList.add(to);

        sendSimpleMessage(toList, subject, body);

        return "EMAIL ENVIADO COM SUCESSO";
    }

    public void sendSimpleMessage(List<String> to, String subject, String text) {

        logger.info("Sending mail to: " + to.toString());

        message.setTo(to.toArray(new String[0]));
        message.setFrom(from);
        message.setSubject(subject);
        message.setText(text);

        emailSender.send(message);
    }
}
