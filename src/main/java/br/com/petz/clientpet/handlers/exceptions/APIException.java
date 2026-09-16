package br.com.petz.clientpet.handlers.exceptions;

import br.com.petz.clientpet.handlers.ErrorApiResponse;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@Getter
@Log4j2
public class APIException extends RuntimeException {
    private final HttpStatus statusException;
    private final ErrorApiResponse bodyException;

    private APIException(HttpStatus statusException, String message, Exception exception) {
        super(message, exception);
        this.statusException = statusException;
        this.bodyException = new ErrorApiResponse(
                message,
                buildDetails(exception));
    }

    public static APIException build(HttpStatus statusException, String message) {
        return new APIException(statusException, message, null);
    }
    public static APIException build(HttpStatus statusException, String message, Exception exception) {
        log.error("Exception: {}", exception.getMessage());
        return new APIException(statusException, message, exception);
    }

    public ResponseEntity<ErrorApiResponse> buildErrorResponseEntity() {
        return new ResponseEntity<>(this.bodyException, this.statusException);
    }

    private List<String> buildDetails(Exception exception) {
        String description = getDescription(exception);
        return description != null ? List.of(description) : List.of();
    }

    private String getDescription(Exception exception) {
        return Optional.ofNullable(exception)
                .map(APIException::getMessageCause).orElse(null);
    }

    private static String getMessageCause(Exception exception) {
        return exception.getCause() != null ? exception.getCause().getMessage() : exception.getMessage();
    }
}
