package example.boot.service;

import example.boot.entity.PersonalAccount;

public interface PersonalAccountService {
    PersonalAccount get(Long id);

    PersonalAccount add(PersonalAccount account);

    PersonalAccount findByAccountNumber(String accountNum);
}
