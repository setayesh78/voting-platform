package webSecondQuestion.common;

public class SecurityConfigurationException extends RuntimeException{

    public SecurityConfigurationException(String message) {
        super(message);
    }

    public SecurityConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
