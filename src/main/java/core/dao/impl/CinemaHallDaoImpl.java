package core.dao.impl;

import core.dao.CinemaHallDao;
import core.lib.Dao;
import core.model.CinemaHall;
import core.model.exception.DataProcessingException;
import core.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Dao
public class CinemaHallDaoImpl implements CinemaHallDao {
    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(cinemaHall);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null || transaction.isActive()) {
                transaction.rollback();
            }
            throw new DataProcessingException("Errored while adding the " + cinemaHall, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return cinemaHall;
    }
    
    @Override
    public List<CinemaHall> getAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Query<CinemaHall> from_cinemaHall
                    = session.createQuery("from CinemaHall", CinemaHall.class);
            return from_cinemaHall.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Errored while retrieving data from DB", e);
        }
    }
}
