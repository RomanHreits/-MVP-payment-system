package example.boot.repository;

import example.boot.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role getByRoleName(String name);
}
