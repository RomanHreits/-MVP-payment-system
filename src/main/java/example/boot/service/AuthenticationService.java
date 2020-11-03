package example.boot.service;

import example.boot.entity.User;

public interface AuthenticationService {
    User register(String email, String password);
}
