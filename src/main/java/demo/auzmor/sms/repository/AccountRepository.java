package demo.auzmor.sms.repository;

import demo.auzmor.sms.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {

    Account findByUsername(String username);
}
