package example.boot.repository;

import example.boot.entity.PersonalAccount;
import org.springframework.data.repository.CrudRepository;

public interface PersonalAccountRepository extends CrudRepository<PersonalAccount, Long> {
}
