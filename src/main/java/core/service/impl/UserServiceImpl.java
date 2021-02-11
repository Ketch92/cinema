package core.service.impl;

import core.dao.UserDao;
import core.model.User;
import core.service.UserService;
import core.util.AuthenticationUtil;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    
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
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
