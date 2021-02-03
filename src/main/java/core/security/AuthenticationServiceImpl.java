package core.security;

import core.lib.Inject;
import core.lib.Service;
import core.model.User;
import core.model.exception.AuthenticationException;
import core.security.AuthenticationService;
import core.service.ShoppingCartService;
import core.service.UserService;
import core.util.AuthenticationUtil;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final String AUTHENTICATION_ERROR_MESSAGE
            = "User with given email and/or password wasn't found";
    @Inject
    private UserService userService;
    @Inject
    private ShoppingCartService shoppingCartService;
    
    @Override
    public User login(String email, String password) throws AuthenticationException {
        Optional<User> user = userService.findByEmail(email);
        if (user.isPresent() && AuthenticationUtil.hashPassword(password,
                user.get().getSalt()).equals(user.get().getPassword())) {
            return user.get();
        }
        throw new AuthenticationException(AUTHENTICATION_ERROR_MESSAGE);
    }
    
    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setPassword(password);
        user.setEmail(email);
        user = userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
