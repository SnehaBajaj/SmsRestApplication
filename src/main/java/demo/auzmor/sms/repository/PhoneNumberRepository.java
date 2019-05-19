package demo.auzmor.sms.repository;

import demo.auzmor.sms.model.PhoneNumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, String> {

    List<PhoneNumber> findByNumber(String number);
}
