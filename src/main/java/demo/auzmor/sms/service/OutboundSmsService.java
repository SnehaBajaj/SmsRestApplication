package demo.auzmor.sms.service;

import demo.auzmor.sms.exception.SmsException;
import demo.auzmor.sms.model.Sms;
import demo.auzmor.sms.model.SmsResponse;
import demo.auzmor.sms.repository.AccountRepository;
import demo.auzmor.sms.repository.SmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OutboundSmsService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    SmsRepository smsRepository;

    public SmsResponse processOutboundSms(Sms sms) {
        checkPairInCache(sms);
        return SmsResponse.builder()
                .message("outbound sms ok")
                .error("")
                .build();
    }

    private void checkPairInCache(Sms sms) {
        List<Sms> smsCacheList = new ArrayList<>();
        smsRepository.findAll().forEach(smsCacheList::add);
        if (!smsCacheList.isEmpty()) {
            throw new SmsException("sms from " + sms.getFrom()
                    + " to " + sms.getTo() + " blocked by STOP request");
        }
    }
}
