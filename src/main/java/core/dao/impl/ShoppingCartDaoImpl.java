package core.dao.impl;

import core.dao.ShoppingCartDao;
import core.model.ShoppingCart;
import core.model.User;
import core.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ShoppingCartDaoImpl extends AbstractDao<ShoppingCart> implements ShoppingCartDao {
    @Override
    public ShoppingCart add(ShoppingCart shoppingCart) {
        return super.create(shoppingCart, HibernateUtils.getSessionFactory());
    }
    
    @Override
    public ShoppingCart getByUser(User user) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Query<ShoppingCart> query = session
                    .createQuery("from ShoppingCart where user = :user", ShoppingCart.class);
            query.setParameter("user", user);
            return query.getSingleResult();
        }
    }
    
    @Override
    public void update(ShoppingCart shoppingCart) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(shoppingCart);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
