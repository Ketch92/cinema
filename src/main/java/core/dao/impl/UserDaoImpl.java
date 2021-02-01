package core.dao.impl;

import core.dao.UserDao;
import core.lib.Dao;
import core.model.User;
import core.model.exception.DataProcessingException;
import core.util.HibernateUtils;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.query.Query;

@Dao
public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    @Override
    public User add(User user) {
        return super.create(user, HibernateUtils.getSessionFactory());
    }
    
    @Override
    public Optional<User> findByEmail(String email) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery("from User where email = :email",
                    User.class);
            query.setParameter("email", email);
            return Optional.of(query.getSingleResult());
        } catch (Exception e) {
            throw new DataProcessingException("Failed getting a user by " + email, e);
        }
    }
}
