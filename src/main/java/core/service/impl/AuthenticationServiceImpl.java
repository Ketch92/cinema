package core.service.impl;

import core.lib.Inject;
import core.lib.Service;
import core.model.User;
import core.model.exception.AuthenticationException;
import core.service.AuthenticationService;
import core.service.UserService;
import core.util.AuthenticationUtils;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final String AUTHENTICATION_ERROR_MESSAGE
            = "User with given email and/or password wasn't found";
    @Inject
    private UserService userService;
    
    @Override
    public User login(String email, String password) throws AuthenticationException {
        User user = userService.findByEmail(email)
                .orElseThrow(() -> new AuthenticationException(AUTHENTICATION_ERROR_MESSAGE));
        if (AuthenticationUtils.hashPassword(password,
                user.getSalt()).equalsIgnoreCase(user.getPassword())) {
            return user;
        }
        throw new AuthenticationException(AUTHENTICATION_ERROR_MESSAGE);
    }
    
    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setPassword(password);
        user.setEmail(email);
        return userService.add(user);
    }
}
