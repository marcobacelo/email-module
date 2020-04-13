package module.dev.services;

import module.dev.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailLayoutService {

    private Email email = new Email();

    public EmailLayoutService() {}

    public EmailLayoutService(String emailBody) {
        this.email.setBody(emailBody);
    }

    public String getEmailLayoutError(String body) {
        this.email.setBody(
                "<!DOCTYPE html>"
                +"<html lang='pt-br'>"
                +"<head>"
                    +"<meta charset='utf-8' />"
                +"</head>"
                +"<body>\n"
                        + "	<h4>COMUNICADO DE EMAIL ENVIADO POR UM PROGRAMADOR</h4>\n"
                        + "	"+body+"\n"
                        + "</body>\n"
                        + "</html>");

        return this.email.getBody();
    }
}
