package webSecondQuestion.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GeneralMicroserviceException extends RuntimeException {
    private String microServiceName;
    private Integer exceptionCode;
    private String localeMessage;

    public GeneralMicroserviceException(String microServiceName, Integer exceptionCode, String localeMessage) {
        this.microServiceName = microServiceName;
        this.exceptionCode = exceptionCode;
        this.localeMessage = localeMessage;
    }

    public GeneralMicroserviceException(String message, String microServiceName, Integer exceptionCode, String localeMessage) {
        super(message);
        this.microServiceName = microServiceName;
        this.exceptionCode = exceptionCode;
        this.localeMessage = localeMessage;
    }

    public GeneralMicroserviceException(String message, Throwable cause, String microServiceName, Integer exceptionCode, String localeMessage) {
        super(message, cause);
        this.microServiceName = microServiceName;
        this.exceptionCode = exceptionCode;
        this.localeMessage = localeMessage;
    }

    public GeneralMicroserviceException(Throwable cause, String microServiceName, Integer exceptionCode, String localeMessage) {
        super(cause);
        this.microServiceName = microServiceName;
        this.exceptionCode = exceptionCode;
        this.localeMessage = localeMessage;
    }
}
