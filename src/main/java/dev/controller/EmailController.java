package dev.controller;

import dev.exceptions.InternalErrorException;
import dev.model.Email;
import dev.services.EmailService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/mail", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EmailController {

    EmailService emailService;

    @PostMapping("/send_mail")
    public ResponseEntity<?> sendMail(@RequestBody Email email)
            throws InternalErrorException {

        String subject = email.getSubject();
        String address = email.getAddress();
        String text = email.getText();

        return ResponseEntity.ok("Requisição feita !!"
            + "\nSubject: " + subject
            + "\nEndereço: " + address
            + "\nTexto: " + text);
    }
}
