package core.service.impl;

import core.dao.OrderDao;
import core.lib.Inject;
import core.lib.Service;
import core.model.Order;
import core.model.ShoppingCart;
import core.model.User;
import core.service.OrderService;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderDao orderDao;
    
    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        return orderDao.completeOrder(shoppingCart);
    }
    
    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.getOrdersHistory(user);
    }
}
