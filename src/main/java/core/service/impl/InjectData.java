package core.service.impl;

import core.model.Role;
import core.model.User;
import core.service.RoleService;
import core.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class InjectData {
    private static final String ADMIN_ROLE = "ADMIN";
    private static final String USER_ROLE = "USER";
    private final RoleService roleService;
    private final UserService userService;
    
    public InjectData(RoleService roleService,
                      UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }
    
    @PostConstruct
    public void inject() {
        Role adminRole = new Role(ADMIN_ROLE);
        roleService.add(adminRole);
        Role userRole = new Role(USER_ROLE);
        roleService.add(userRole);
        User admin = new User();
        admin.setEmail("admin@mail.com");
        admin.setPassword("1234");
        admin.setUserRole(Set.of(adminRole));
        userService.add(admin);
    }
}
