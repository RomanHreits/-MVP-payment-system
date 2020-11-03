package example.boot.service;

import example.boot.entity.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(String roleName);
}
