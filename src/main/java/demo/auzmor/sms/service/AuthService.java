package demo.auzmor.sms.service;

import demo.auzmor.sms.cache.AccountCache;
import demo.auzmor.sms.model.Account;
import demo.auzmor.sms.model.Sms;
import demo.auzmor.sms.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class AuthService {

    @Autowired
    AccountCache accountCache;

    @Autowired
    AccountRepository accountRepository;

    public void authenticateRequest(@Valid Sms sms) {
    }

    public Iterable<Account> fetchAllAccounts() {
        Iterable<Account> accountRepositoryAll = accountRepository.findAll();
        return accountRepositoryAll;
    }
}
