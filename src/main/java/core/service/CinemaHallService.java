package core.service;

import core.model.CinemaHall;
import java.util.List;

public interface CinemaHallService {
    CinemaHall add(CinemaHall cinemaHall);
    
    List<CinemaHall> getAll();
}
