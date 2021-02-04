package core.service.impl;

import core.dao.ShoppingCartDao;
import core.dao.TicketDao;
import core.lib.Inject;
import core.lib.Service;
import core.model.MovieSession;
import core.model.ShoppingCart;
import core.model.Ticket;
import core.model.User;
import core.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Inject
    private ShoppingCartDao shoppingCartDao;
    @Inject
    private TicketDao ticketDao;
    
    @Override
    public void addSession(MovieSession movieSession, User user) {
        Ticket ticket = new Ticket();
        ticket.setMovieSession(movieSession);
        ticket.setUser(user);
        ShoppingCart byUser = shoppingCartDao.getByUser(user);
        ticket = ticketDao.add(ticket);
        byUser.getTicketList().add(ticket);
        shoppingCartDao.update(byUser);
    }
    
    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartDao.getByUser(user);
    }
    
    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartDao.add(shoppingCart);
    }
    
    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.getTicketList().clear();
        shoppingCartDao.update(shoppingCart);
    }
}
