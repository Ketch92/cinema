package core.service.impl;

import core.dao.CinemaHallDao;
import core.lib.Inject;
import core.lib.Service;
import core.model.CinemaHall;
import core.service.CinemaHallService;
import java.util.List;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {
    
    @Inject
    private CinemaHallDao cinemaHallDao;
    
    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        return cinemaHallDao.add(cinemaHall);
    }
    
    @Override
    public List<CinemaHall> getAll() {
        return cinemaHallDao.getAll();
    }
}
