package demo.auzmor.sms.service;

import demo.auzmor.sms.model.Sms;
import demo.auzmor.sms.model.SmsResponse;
import demo.auzmor.sms.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutboundSmsService {

    @Autowired
    AccountRepository accountRepository;

    public SmsResponse processOutboundSms(Sms sms) {
        return SmsResponse.builder()
                .message("outbound sms ok")
                .error("")
                .build();
    }
}
