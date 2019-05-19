package demo.auzmor.sms.service;

import demo.auzmor.sms.model.Account;
import demo.auzmor.sms.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DetailsService implements UserDetailsService {

    @Autowired
    AccountRepository accounts;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accounts.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException(username + " was not found");
        }
        account.setAuthId(account.getAuthId());
        return new User(account.getUsername(),
                account.getAuthId(),
                AuthorityUtils.NO_AUTHORITIES);
    }
}
