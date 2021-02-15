package core.dao.impl;

import core.dao.CinemaHallDao;
import core.model.CinemaHall;
import java.util.List;
import java.util.Optional;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CinemaHallDaoImpl extends AbstractDao<CinemaHall> implements CinemaHallDao {
    public CinemaHallDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    
    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        return super.create(cinemaHall);
    }
    
    @Override
    public Optional<CinemaHall> get(Long id) {
        return super.get(CinemaHall.class, id);
    }
    
    @Override
    public List<CinemaHall> getAll() {
        return super.getAll(CinemaHall.class);
    }
}
