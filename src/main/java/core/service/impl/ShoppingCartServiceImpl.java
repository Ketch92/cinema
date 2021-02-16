package core.service.impl;

import core.dao.ShoppingCartDao;
import core.dao.TicketDao;
import core.model.MovieSession;
import core.model.ShoppingCart;
import core.model.Ticket;
import core.model.User;
import core.model.exception.DataProcessingException;
import core.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private static final String errorMessage = "Error has occurred while retrieving the data from DB";
    private final ShoppingCartDao shoppingCartDao;
    private final TicketDao ticketDao;
    
    public ShoppingCartServiceImpl(ShoppingCartDao shoppingCartDao, TicketDao ticketDao) {
        this.shoppingCartDao = shoppingCartDao;
        this.ticketDao = ticketDao;
    }
    
    @Override
    public void addSession(MovieSession movieSession, User user) {
        Ticket ticket = new Ticket();
        ticket.setMovieSession(movieSession);
        ticket.setUser(user);
        ShoppingCart byUser = shoppingCartDao.getByUser(user);
        ticketDao.add(ticket);
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
    public ShoppingCart get(Long id) {
        return shoppingCartDao.get(id)
                .orElseThrow(() -> new DataProcessingException(errorMessage));
    }
    
    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.getTicketList().clear();
        shoppingCartDao.update(shoppingCart);
    }
}
