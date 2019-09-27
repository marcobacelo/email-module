package dev.controller;

import dev.exceptions.InternalErrorException;
import dev.model.Email;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/mail", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EmailController {


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

    @GetMapping("/getEmails")
    public ResponseEntity<?> getRadios(Email email) {

        String subject = "EMAIL TIM";
        String address = "marcobacelo90@gmail.com";
        String text = "BLABLABLA";

        return ResponseEntity.ok("Requisição feita !!"
                + "\nSubject: " + subject
                + "\nEndereço: " + address
                + "\nTexto: " + text);
    }
}
