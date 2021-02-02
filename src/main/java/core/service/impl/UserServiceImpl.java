package core.service.impl;

import core.dao.UserDao;
import core.lib.Inject;
import core.lib.Service;
import core.model.User;
import core.service.UserService;
import core.util.AuthenticationUtils;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;
    
    @Override
    public User add(User user) {
        user.setSalt(AuthenticationUtils.getSalt());
        user.setPassword(AuthenticationUtils.hashPassword(user.getPassword(), user.getSalt()));
        return userDao.add(user);
    }
    
    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
