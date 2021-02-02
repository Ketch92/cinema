package core.dao;

import core.model.CinemaHall;
import java.util.List;

public interface CinemaHallDao {
    CinemaHall add(CinemaHall cinemaHall);
    
    List<CinemaHall> getAll();
}
