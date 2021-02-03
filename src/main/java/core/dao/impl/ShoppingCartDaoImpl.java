package core.dao.impl;

import core.dao.ShoppingCartDao;
import core.lib.Dao;
import core.model.ShoppingCart;
import core.model.User;
import core.model.exception.DataProcessingException;
import core.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Dao
public class ShoppingCartDaoImpl extends AbstractDao<ShoppingCart> implements ShoppingCartDao {
    @Override
    public ShoppingCart add(ShoppingCart shoppingCart) {
        return super.create(shoppingCart, HibernateUtils.getSessionFactory());
    }
    
    @Override
    public ShoppingCart getByUser(User user) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Query<ShoppingCart> query = session
                    .createQuery("from ShoppingCart sc "
                                 + " left join fetch sc.ticketList tl"
                                 + " left join fetch tl.movieSession ms"
                                 + " left join fetch ms.movie"
                                 + " left join fetch ms.cinemaHall"
                                 + " where sc.user = :user", ShoppingCart.class);
            query.setParameter("user", user);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new DataProcessingException("An error has occurred while retrieving the data for "
                                              + user);
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
            throw new DataProcessingException("An error has occurred while updating "
                                              + shoppingCart);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
