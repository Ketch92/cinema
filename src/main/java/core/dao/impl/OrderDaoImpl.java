package core.dao.impl;

import core.dao.OrderDao;
import core.lib.Dao;
import core.model.Order;
import core.model.User;
import core.model.exception.DataProcessingException;
import core.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

@Dao
public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {
    @Override
    public Order add(Order order) {
        return super.create(order, HibernateUtils.getSessionFactory());
    }
    
    @Override
    public List<Order> getOrdersHistory(User user) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Query<Order> query = session.createQuery("select distinct o from Order o "
                                                     + "left join fetch o.tickets t "
                                                     + "left join fetch o.user "
                                                     + "left join fetch t.movieSession ms "
                                                     + "left join fetch ms.cinemaHall "
                                                     + "left join fetch ms.movie "
                                                     + "where o.user = :user", Order.class);
            query.setParameter("user", user);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Unable to get data for "
                                              + user + " due to an error ", e);
        }
    }
}
