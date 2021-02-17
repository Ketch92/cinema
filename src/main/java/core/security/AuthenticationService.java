package core.security;

import core.model.User;
import core.model.exception.AuthenticationException;
import core.model.exception.UserRegistrationException;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;
    
    User register(String email, String password) throws UserRegistrationException;
}
