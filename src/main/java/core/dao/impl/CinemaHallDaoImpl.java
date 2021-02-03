package core.dao.impl;

import core.dao.CinemaHallDao;
import core.lib.Dao;
import core.model.CinemaHall;
import core.util.HibernateUtils;
import java.util.List;

@Dao
public class CinemaHallDaoImpl extends AbstractDao<CinemaHall> implements CinemaHallDao {
    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        return super.create(cinemaHall, HibernateUtils.getSessionFactory());
    }
    
    @Override
    public List<CinemaHall> getAll() {
        return super.getAll(CinemaHall.class, HibernateUtils.getSessionFactory());
    }
}
