package core.dao.impl;

import core.dao.OrderDao;
import core.model.Order;
import core.model.User;
import core.model.exception.DataProcessingException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {
    public OrderDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    
    @Override
    public Order add(Order order) {
        return super.create(order);
    }
    
    @Override
    public List<Order> getOrdersHistory(User user) {
        try (Session session = getSessionFactory().openSession()) {
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
