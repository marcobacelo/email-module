package module.dev.exceptions;

public class SmtpException extends Exception {

    private static final String DEFAULT_MESSAGE = "SMTP Error";
    private String log = "";

    public SmtpException() {
        super(DEFAULT_MESSAGE);
    }

    public SmtpException(String message) {
        super(message);
    }

    public SmtpException(String message, String log) {
        super(message);
        this.log = log;
    }
}
