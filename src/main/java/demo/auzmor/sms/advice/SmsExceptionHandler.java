package demo.auzmor.sms.advice;

import demo.auzmor.sms.exception.SmsException;
import demo.auzmor.sms.model.SmsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ValidationException;


@ControllerAdvice
public class SmsExceptionHandler {

    /*@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<SmsResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<SmsResponse> handleAuthenticationException(AuthenticationException ex) {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }*/

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<SmsResponse> handleValidationException(ValidationException ex) {
        return new ResponseEntity<>(SmsResponse.builder()
                .message("")
                .error(ex.getMessage())
                .build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SmsException.class)
    public ResponseEntity<SmsResponse> handleSmsException(SmsException ex) {
        return new ResponseEntity<>(SmsResponse.builder()
                .message("")
                .error(ex.getMessage())
                .build(),
                HttpStatus.FORBIDDEN);
    }
}
