package core.service;

import core.model.MovieSession;
import core.model.ShoppingCart;
import core.model.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);
    
    ShoppingCart getByUser(User user);
    
    void registerNewShoppingCart(User user);
    
    void clear(ShoppingCart shoppingCart);
}
