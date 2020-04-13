package module.dev.services;

import module.dev.DAO.MailDAO;
import module.dev.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService {

    @Autowired
    MailDAO mailDAO;

    public List<Email> getAllMails(){
        return mailDAO.findAll();
    }
}
