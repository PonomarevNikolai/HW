package Basic.HW.service;

import Basic.HW.exception.ExcHandler.TypicalError;
import lombok.Getter;

@Getter
public class ServiceException extends Exception {
    private final TypicalError typicalError;

    public ServiceException(String message, TypicalError typicalError) {
        super(message);
        this.typicalError = typicalError;
    }
}
