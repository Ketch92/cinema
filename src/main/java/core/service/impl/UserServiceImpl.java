package core.service.impl;

import core.lib.Inject;
import core.lib.Service;
import core.model.User;
import core.service.UserService;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;
    
    @Override
    public User add(User user) {
        return userDao.add(user);
    }
    
    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
