package example.boot.security;

import example.boot.entity.Role;
import example.boot.entity.User;
import example.boot.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email);
        if (user != null) {
            org.springframework.security.core.userdetails.User.UserBuilder userBuilder =
                    org.springframework.security.core.userdetails.User.withUsername(email);
            userBuilder.password(user.getPassword());
            userBuilder.roles(user.getRoles().stream()
                    .map(Role::getRoleName).toArray(String[]::new));
            return userBuilder.build();
        }
        throw new RuntimeException("Can't authenticate, please enter correct email and password");
    }
}
