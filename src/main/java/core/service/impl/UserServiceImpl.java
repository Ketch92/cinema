package core.service.impl;

import core.dao.UserDao;
import core.model.User;
import core.model.exception.DataProcessingException;
import core.service.UserService;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    public static final String ERROR_MESSAGE = "Error has occurred while retrieving the data";
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    
    public UserServiceImpl(UserDao userDao,
                           PasswordEncoder hashPassword) {
        this.userDao = userDao;
        this.passwordEncoder = hashPassword;
    }
    
    @Override
    public User add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDao.add(user);
    }
    
    @Override
    public User get(Long id) {
        return userDao.get(id)
                .orElseThrow(() -> new DataProcessingException(ERROR_MESSAGE));
    }
    
    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
