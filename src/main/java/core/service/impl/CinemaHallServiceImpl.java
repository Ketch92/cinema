package core.service.impl;

import core.dao.CinemaHallDao;
import core.model.CinemaHall;
import core.service.CinemaHallService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {
    private CinemaHallDao cinemaHallDao;
    
    public CinemaHallServiceImpl(CinemaHallDao cinemaHallDao) {
        this.cinemaHallDao = cinemaHallDao;
    }
    
    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        return cinemaHallDao.add(cinemaHall);
    }
    
    @Override
    public CinemaHall get(Long id) {
        return cinemaHallDao.get(id);
    }
    
    @Override
    public List<CinemaHall> getAll() {
        return cinemaHallDao.getAll();
    }
}
