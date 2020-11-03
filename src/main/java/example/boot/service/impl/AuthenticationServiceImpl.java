package example.boot.service.impl;

import example.boot.entity.PersonalAccount;
import example.boot.entity.Role;
import example.boot.entity.User;
import example.boot.repository.RoleRepository;
import example.boot.service.AuthenticationService;
import example.boot.service.PersonalAccountService;
import example.boot.service.UserService;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final PersonalAccountService accountService;
    private final RoleRepository roleRepository;

    public AuthenticationServiceImpl(UserService userService,
                                     PersonalAccountService accountService,
                                     RoleRepository roleRepository) {
        this.userService = userService;
        this.accountService = accountService;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public User register(String email, String password) {
        User user = new User(email, password);
        Role roleName;
        if (email.equals("roman@in.ua")) {
            roleName = roleRepository.getByRoleName("ADMIN");
            user.setRoles(Set.of(roleName));
            userService.add(user);
            return user;
        }
        roleName = roleRepository.getByRoleName("USER");
        user.setRoles(Set.of(roleName));
        userService.add(user);
        accountService.add(new PersonalAccount(user, getRandomAccountNumber(), 1000L));
        return user;
    }

    private String getRandomAccountNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append((int) (Math.random() * 8999) + 1000);
        }
        return sb.toString();
    }
}
