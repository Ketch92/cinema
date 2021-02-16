package core.dao;

import core.model.ShoppingCart;
import core.model.User;
import java.util.Optional;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);
    
    ShoppingCart getByUser(User user);
    
    Optional<ShoppingCart> get(Long id);
    
    void update(ShoppingCart shoppingCart);
}
