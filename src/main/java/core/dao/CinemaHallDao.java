package core.dao;

import core.model.CinemaHall;
import java.util.List;

public interface CinemaHallDao {
    CinemaHall add(CinemaHall cinemaHall);
    
    CinemaHall get(Long id);
    
    List<CinemaHall> getAll();
}
