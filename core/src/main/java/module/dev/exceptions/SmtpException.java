package module.dev.exceptions;

public class SmtpException extends Exception {

    private static final String DEFAULT_MESSAGE = "SMTP Error";

    public SmtpException() {
        super(DEFAULT_MESSAGE);
    }

    public SmtpException(String message) {
        super(message);
    }

    public SmtpException(String message, String log) {
        super(message);
    }

    public SmtpException(String message, String something, String log) {
        super(message);
    }
}
