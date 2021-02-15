package core.service;

import core.model.MovieSession;
import java.time.LocalDate;
import java.util.List;

public interface MovieSessionService {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);
    
    MovieSession get(Long id);
    
    void update(MovieSession movieSession);
    
    void delete(Long id);

    MovieSession add(MovieSession session);
}
