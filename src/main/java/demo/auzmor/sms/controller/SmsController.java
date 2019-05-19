package demo.auzmor.sms.controller;

import demo.auzmor.sms.model.SmsResponse;
import demo.auzmor.sms.model.Sms;
import demo.auzmor.sms.service.AuthService;
import demo.auzmor.sms.service.InboundSmsService;
import demo.auzmor.sms.service.OutboundSmsService;
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

    @Autowired
    AuthService authService;

    @Autowired
    InboundSmsService inboundSmsService;

    @Autowired
    OutboundSmsService outboundSmsService;

    @PostMapping("/inbound/sms")
    public ResponseEntity<SmsResponse> inboundSms(@Valid @RequestBody Sms sms, Errors errors){
        validateInput(sms, errors);
        SmsResponse smsResponse = inboundSmsService.processInboundSms(sms);
        return new ResponseEntity<>(smsResponse, HttpStatus.OK);
    }

    @PostMapping("/outbound/sms")
    public ResponseEntity<SmsResponse> outboundSms(@Valid @RequestBody Sms sms, Errors errors) {
        validateInput(sms, errors);
        SmsResponse smsResponse = outboundSmsService.processOutboundSms(sms);
        return new ResponseEntity<>(smsResponse, HttpStatus.OK);
    }

    private void validateInput(@RequestBody @Valid Sms sms, Errors errors) {
        validator.validate(sms, errors);
        if (errors.hasErrors()) {
            throw new ValidationException(errors.getFieldError().getDefaultMessage());
        }
    }

}
