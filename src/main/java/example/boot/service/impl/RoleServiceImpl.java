package example.boot.service.impl;

import example.boot.entity.Role;
import example.boot.repository.RoleRepository;
import example.boot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void add(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleRepository.getByRoleName(roleName);
    }
}
