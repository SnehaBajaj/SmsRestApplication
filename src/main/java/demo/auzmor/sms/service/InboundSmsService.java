package demo.auzmor.sms.service;

import demo.auzmor.sms.model.PhoneNumber;
import demo.auzmor.sms.model.Sms;
//import demo.auzmor.sms.model.SmsCache;
import demo.auzmor.sms.model.SmsResponse;
import demo.auzmor.sms.repository.AccountRepository;
import demo.auzmor.sms.repository.PhoneNumberRepository;
import demo.auzmor.sms.repository.SmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;
import java.util.List;

@Service
public class InboundSmsService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    @Autowired
    SmsRepository smsRepository;

    public SmsResponse processInboundSms(Sms sms) {
        List<PhoneNumber> phoneNumbers = phoneNumberRepository.findByNumber(sms.getTo());
        if (!phoneNumbers.isEmpty()) {
            checkIfSameAsBasicAuthAccount(phoneNumbers.get(0));
        }
        storeInCache(sms);
        return SmsResponse.builder()
                .message("inbound sms ok")
                .error("")
                .build();
    }

    private void storeInCache(Sms sms) {
        String text = sms.getText();
        if(text.equals("STOP") ||
                text.equals("STOP\n") ||
                text.equals("STOP\r") ||
                text.equals("STOP\r\n")){
//            SmsCache smsCache = new SmsCache(sms.getFrom(), sms.getTo());
            smsRepository.save(sms);
        }
    }

    private void checkIfSameAsBasicAuthAccount(PhoneNumber phoneNumber) {

    }
}
