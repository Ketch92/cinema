package core.dao.impl;

import core.dao.UserDao;
import core.model.User;
import core.model.exception.DataProcessingException;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    
    @Override
    public User add(User user) {
        return super.create(user);
    }
    
    @Override
    public Optional<User> get(Long id) {
        return super.get(User.class, id);
    }
    
    @Override
    public Optional<User> findByEmail(String email) {
        try (Session session = getSessionFactory().openSession()) {
            Query<User> query = session.createQuery("from User where email = :email",
                    User.class);
            query.setParameter("email", email);
            return query.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Failed getting a user by " + email, e);
        }
    }
}
