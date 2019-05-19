package demo.auzmor.sms.service;

import demo.auzmor.sms.model.PhoneNumber;
import demo.auzmor.sms.model.Sms;
import demo.auzmor.sms.model.SmsResponse;
import demo.auzmor.sms.repository.AccountRepository;
import demo.auzmor.sms.repository.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InboundSmsService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    public SmsResponse processInboundSms(Sms sms) {
        List<PhoneNumber> phoneNumbers = phoneNumberRepository.findByNumber(sms.getTo());
        if (!phoneNumbers.isEmpty()) {
            checkIfSameAsBasicAuthAccount(phoneNumbers.get(0));
        }
        return SmsResponse.builder()
                .message("inbound sms ok")
                .error("")
                .build();
    }

    private void checkIfSameAsBasicAuthAccount(PhoneNumber phoneNumber) {

    }
}
