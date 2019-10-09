package module.dev.exceptions;

public class SmtpException extends Exception {

    private static final String DEFAULT_MESSAGE = "SMTP Error";
    private String log = "";

    public SmtpException() {
    }

    public SmtpException(String log) {
        super(log);
    }

    public SmtpException(String log, Throwable throwable) {
        super(log);
    }
}
