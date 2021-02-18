package core.service;

import core.model.Role;

public interface RoleService {
    Role add(Role role);
    
    Role getRoleByName(String roleName);
}
