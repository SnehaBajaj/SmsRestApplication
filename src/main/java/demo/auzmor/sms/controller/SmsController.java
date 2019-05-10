package demo.auzmor.sms.controller;

import demo.auzmor.sms.model.Response;
import demo.auzmor.sms.model.Sms;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SmsController {

    @PostMapping("/inbound/sms")
    public Response inboundSms(@Valid @RequestBody Sms sms){
        return new Response();
    }

    @PostMapping("/outbound/sms")
    public Response outboundSms(@Valid @RequestBody Sms sms) {
        return new Response();
    }

}
