package core.dao.impl;

import core.dao.TicketDao;
import core.model.Ticket;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl extends AbstractDao<Ticket> implements TicketDao {
    public TicketDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    
    @Override
    public Ticket add(Ticket ticket) {
        return super.create(ticket);
    }
}
