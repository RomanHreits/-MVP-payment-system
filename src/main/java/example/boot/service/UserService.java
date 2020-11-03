package example.boot.service;

import example.boot.entity.User;
import java.util.List;

public interface UserService {
    User add(User user);

    List<User> getAll();

    User findByEmail(String email);
}
