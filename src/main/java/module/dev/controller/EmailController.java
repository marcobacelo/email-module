package module.dev.controller;

import module.dev.exceptions.InternalErrorException;
import module.dev.exceptions.SmtpException;
import module.dev.helper.MailHelper;
import module.dev.model.Email;
//import module.dev.services.EmailLayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/mail", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EmailController {

//    private EmailLayoutService emailLayoutService;

    @Autowired
    private MailHelper mailHelper;

    @PostMapping("/send_mail")
    public ResponseEntity<?> sendMail(@RequestBody Email email)
            throws SmtpException {

        return ResponseEntity.ok(mailHelper.prepareMessage(email.getAddress(), email.getSubject(), email.getBody()));
    }
}
