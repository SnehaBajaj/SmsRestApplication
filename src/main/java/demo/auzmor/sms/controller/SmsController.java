package demo.auzmor.sms.controller;

import demo.auzmor.sms.model.Response;
import demo.auzmor.sms.model.Sms;
import demo.auzmor.sms.validator.RequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.ValidationException;

@RestController
public class SmsController {

    @Autowired
    RequestValidator validator;

    @PostMapping("/inbound/sms")
    public ResponseEntity<Response> inboundSms(@Valid @RequestBody Sms sms, Errors errors){
        validateInput(sms, errors);
        return new ResponseEntity<>(Response.builder()
                .message("inbound sms ok")
                .error("")
                .build(),
                HttpStatus.OK);
    }

    @PostMapping("/outbound/sms")
    public ResponseEntity<Response> outboundSms(@Valid @RequestBody Sms sms, Errors errors) {
        validateInput(sms, errors);
        return new ResponseEntity<>(Response.builder()
                .message("outbound sms ok")
                .error("")
                .build(),
                HttpStatus.OK);
    }

    private void validateInput(@RequestBody @Valid Sms sms, Errors errors) {
        validator.validate(sms, errors);
        if (errors.hasErrors()) {
            throw new ValidationException(errors.getFieldError().getDefaultMessage());
        }
    }

}
