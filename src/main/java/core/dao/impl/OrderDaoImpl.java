package core.dao.impl;

import core.dao.OrderDao;
import core.model.Order;
import core.model.ShoppingCart;
import core.model.User;
import core.model.exception.DataProcessingException;
import core.util.HibernateUtils;
import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {
    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setUser(shoppingCart.getUser());
        order.setTickets(shoppingCart.getTicketList());
        return super.create(order, HibernateUtils.getSessionFactory());
    }
    
    @Override
    public List<Order> getOrdersHistory(User user) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Query<Order> query = session.createQuery("from Order where user = :user", Order.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Unable to get data for "
                                              + user + " due to an error ", e);
        }
    }
}
