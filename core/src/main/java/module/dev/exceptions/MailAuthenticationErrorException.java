package module.dev.exceptions;

import org.springframework.mail.MailAuthenticationException;

public class MailAuthenticationErrorException extends SmtpException {

    private static final String DEFAULT_MESSAGE = "Mail Authentication Error";

    public MailAuthenticationErrorException() {
        super(DEFAULT_MESSAGE);
    }

    public MailAuthenticationErrorException(String log) {
        super(DEFAULT_MESSAGE, log);
    }

    public MailAuthenticationErrorException(String message, String log) {
        super(DEFAULT_MESSAGE, message, log);
    }
}
