package dev.controller;

import dev.exceptions.InternalErrorException;
import dev.model.Email;
import dev.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/send_email", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/send_mail")
    public ResponseEntity<?> sendMail(@RequestBody Email email)
            throws InternalErrorException {

        return ResponseEntity.ok("REQUISIÇÃO FUNFOU !! BOA DEV");
    }
}
