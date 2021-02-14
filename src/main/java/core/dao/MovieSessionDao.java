package core.dao;

import core.model.MovieSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieSessionDao {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);
    
    Optional<MovieSession> get(Long id);
    
    MovieSession add(MovieSession session);
    
    void update(MovieSession movieSession);
    
    void delete(MovieSession movieSession);
}
