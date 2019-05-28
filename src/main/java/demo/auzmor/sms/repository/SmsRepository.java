package demo.auzmor.sms.repository;

import demo.auzmor.sms.model.Sms;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmsRepository extends CrudRepository<Sms, String> {
}
