package demo.auzmor.sms.validator;

import demo.auzmor.sms.model.Sms;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class RequestValidator {

    public void validate(Sms sms, Errors errors) {

        if (sms.getFrom().length() > 16 || sms.getFrom().length() < 6) {
            errors.reject("from");
        }

        if (sms.getTo().length() > 16 || sms.getTo().length() < 6) {
            errors.reject("to");
        }

        if (sms.getText().length() > 120) {
            errors.reject("text");
        }

    }
}
