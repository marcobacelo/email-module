package module.dev.exceptions;

public class MailParseErrorException extends SmtpException {

    private static final String DEFAULT_MESSAGE = "Invalid sender!";

    public MailParseErrorException() {
        super(DEFAULT_MESSAGE);
    }

    public MailParseErrorException(String log) {
        super(DEFAULT_MESSAGE, log);
    }

    public MailParseErrorException(String message, String log) {
        super(message, DEFAULT_MESSAGE, log);
    }
}
