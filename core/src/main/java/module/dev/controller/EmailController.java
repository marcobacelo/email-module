package module.dev.controller;

import module.dev.exceptions.SmtpException;
import module.dev.helper.MailHelper;
import module.dev.model.Email;
import module.dev.services.EmailLayoutService;
import module.dev.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/mail", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EmailController {

    @Autowired
    private MailHelper mailHelper;

    @Autowired
    private EmailLayoutService emailLayoutService;

    @Autowired
    private MailService mailService;

    @GetMapping("/get_all_mails")
    public ResponseEntity<?> getMails() {
        return ResponseEntity.ok(mailService.getAllMails());
    }

    @PostMapping("/send_mail")
    public ResponseEntity<?> sendMail(@RequestBody Email email)
            throws SmtpException {

        String body = emailLayoutService.getEmailLayoutError(email.getBody());

        return ResponseEntity.ok(mailHelper.prepareMessage(email.getAddress(), email.getSubject(), body));
    }
}
