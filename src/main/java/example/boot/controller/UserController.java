package example.boot.controller;

import example.boot.dto.AccountDto;
import example.boot.entity.PersonalAccount;
import example.boot.entity.User;
import example.boot.mapper.UserMapper;
import example.boot.service.AuthenticationService;
import example.boot.service.PersonalAccountService;
import example.boot.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;
    private final PersonalAccountService accountService;
    private final AuthenticationService authenticationService;
    private final UserMapper mapper;

    public UserController(UserService userService,
                          PersonalAccountService accountService,
                          AuthenticationService authenticationService,
                          UserMapper mapper) {
        this.userService = userService;
        this.accountService = accountService;
        this.authenticationService = authenticationService;
        this.mapper = mapper;
    }

    @GetMapping("/user")
    public String getUsers(Model model, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        List<User> all = userService.getAll();
        all.removeIf(user -> user.getEmail().equals(userDetails.getUsername())
                || user.getRoles().stream().anyMatch(role -> role.getRoleName().equals("ADMIN")));
        model.addAttribute("users", all);
        return "allUsers";
    }

    @PostMapping("/sendUnit")
    public String sendUnit(@Valid AccountDto accountDto,
                           Authentication authentication, Model model) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User fromUser = userService.findByEmail(userDetails.getUsername());
        PersonalAccount fromAccount = accountService.get(fromUser.getId());
        fromAccount.setUnits(fromAccount.getUnits() - accountDto.getUnits());

        PersonalAccount toAccount = accountService.get(accountDto.getId());
        toAccount.setUnits(toAccount.getUnits() + accountDto.getUnits());
        accountService.add(fromAccount);
        accountService.add(toAccount);
        return "redirect:/";
    }

    @GetMapping("/userPage")
    public String homePage(Authentication authentication, Model mode) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.findByEmail(userDetails.getUsername());
        PersonalAccount personalAccount = accountService.get(user.getId());
        mode.addAttribute("response", List.of(mapper.fromEntitiesToDto(personalAccount, user)));
        return "homePage";
    }
}
