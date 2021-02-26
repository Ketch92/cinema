package core.dao;

import core.model.Role;
import java.util.Optional;

public interface RoleDao {
    Role add(Role role);
    
    Optional<Role> getRoleByName(String roleName);
}
