package example.boot.controller;

import example.boot.dto.UserRegistrationDto;
import example.boot.entity.User;
import example.boot.service.AuthenticationService;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {
    private final AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @GetMapping("/register")
    public String showAddPersonPage() {
        return "register";
    }

    @PostMapping("/add")
    public String add(@Valid UserRegistrationDto user) {
        User register = service.register(user.getEmail(), user.getPassword());
        return "redirect:/user";
    }
}
