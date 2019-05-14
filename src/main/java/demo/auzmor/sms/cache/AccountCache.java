package demo.auzmor.sms.cache;

import demo.auzmor.sms.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Component;

import javax.persistence.FetchType;

@Component
public class AccountCache {

    @Autowired
    AccountRepository accountRepository;

    public void loadCache() {
        accountRepository.findAll();
    }
}
