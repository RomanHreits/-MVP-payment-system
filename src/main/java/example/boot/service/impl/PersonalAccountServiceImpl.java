package example.boot.service.impl;

import example.boot.entity.PersonalAccount;
import example.boot.repository.PersonalAccountRepository;
import example.boot.service.PersonalAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalAccountServiceImpl implements PersonalAccountService {
    @Autowired
    private PersonalAccountRepository accountRepository;

    @Override
    public PersonalAccount get(Long id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public PersonalAccount add(PersonalAccount account) {
        return accountRepository.save(account);
    }
}
