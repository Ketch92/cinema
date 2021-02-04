package core.dao.impl;

import core.dao.TicketDao;
import core.lib.Dao;
import core.model.Ticket;
import core.util.HibernateUtils;

@Dao
public class TicketDaoImpl extends AbstractDao<Ticket> implements TicketDao {
    @Override
    public Ticket add(Ticket ticket) {
        return super.create(ticket, HibernateUtils.getSessionFactory());
    }
}
