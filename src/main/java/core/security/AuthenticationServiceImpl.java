package core.security;

import core.model.User;
import core.model.exception.UserRegistrationException;
import core.service.RoleService;
import core.service.ShoppingCartService;
import core.service.UserService;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final String AUTHENTICATION_ERROR_MESSAGE
            = "User with given email and/or password wasn't found";
    private static final String USER_REGISTRATION_EXC_MESSAGE
            = "User with given email already exists."
              + " Please, give choose another email and try again.";
    
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;
    
    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService,
                                     RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }
    
    @Override
    public User register(String email, String password) throws UserRegistrationException {
        User user = new User();
        user.setPassword(password);
        user.setEmail(email);
        user.setUserRole(Set.of(roleService.getRoleByName("USER")));
        try {
            user = userService.add(user);
            shoppingCartService.registerNewShoppingCart(user);
        } catch (Exception e) {
            throw new UserRegistrationException(USER_REGISTRATION_EXC_MESSAGE, e);
        }
        return user;
    }
}
