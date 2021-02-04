package core.dao;

import core.model.Order;
import core.model.ShoppingCart;
import core.model.User;
import java.util.List;

public interface OrderDao {
    Order completeOrder(ShoppingCart shoppingCart);
    
    List<Order> getOrdersHistory(User user);
}
