package example.boot.controller;

import example.boot.entity.Role;
import example.boot.service.AuthenticationService;
import example.boot.service.RoleService;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class InjectData {
    private final AuthenticationService authenticationService;
    private final RoleService roleService;

    public InjectData(AuthenticationService authenticationService, RoleService roleService) {
        this.authenticationService = authenticationService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void addDataToDB() {
        saveUsers();
    }

    private void saveUsers() {
        Role adminRole = new Role("ADMIN");
        Role userRole = new Role("USER");
        roleService.add(adminRole);
        roleService.add(userRole);
        authenticationService.register("roman@in.ua", "roman");
        authenticationService.register("ruslan@in.ua", "ruslan");
        authenticationService.register("bohdan@in.ua", "bohdan");
        authenticationService.register("andriy@in.ua", "andriy");
        authenticationService.register("oleksiy@in.ua", "oleksiy");
    }
}
