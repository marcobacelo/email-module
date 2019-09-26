package dev.services;

import dev.helper.MailHelper;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailService {

    @Autowired
    MailHelper mailHelper;
}
