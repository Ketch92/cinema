package core.service.impl;

import core.dao.UserDao;
import core.model.User;
import core.model.exception.DataProcessingException;
import core.service.UserService;
import core.util.AuthenticationUtil;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    public static final String errorMessage = "Error has occurred while retrieving the data";
    private final UserDao userDao;
    
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    
    @Override
    public User add(User user) {
        user.setSalt(AuthenticationUtil.getSalt());
        user.setPassword(AuthenticationUtil.hashPassword(user.getPassword(), user.getSalt()));
        return userDao.add(user);
    }
    
    @Override
    public User get(Long id) {
        return userDao.get(id)
                .orElseThrow(() -> new DataProcessingException(errorMessage));
    }
    
    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
