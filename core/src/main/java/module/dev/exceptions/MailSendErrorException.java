package module.dev.exceptions;

import org.springframework.mail.MailSendException;

public class MailSendErrorException extends SmtpException {

    private static final String DEFAULT_MESSAGE = "Mail Sender Error";

    public MailSendErrorException() {
        super(DEFAULT_MESSAGE);
    }

    public MailSendErrorException(String log) {
        super(DEFAULT_MESSAGE, log);
    }

    public MailSendErrorException(String message, String log) {
        super(DEFAULT_MESSAGE, message, log);
    }
}
