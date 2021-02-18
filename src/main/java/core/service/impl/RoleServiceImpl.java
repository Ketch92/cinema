package core.service.impl;

import core.dao.RoleDao;
import core.model.Role;
import core.service.RoleService;

public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;
    
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
    
    @Override
    public Role add(Role role) {
        return roleDao.add(role);
    }
    
    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName).orElseThrow();
    }
}
