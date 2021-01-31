package core.service.impl;

import core.model.MovieSession;
import core.service.MovieSessionService;
import java.time.LocalDate;
import java.util.List;

public class MovieSessionServiceImpl implements MovieSessionService {
    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return null;
    }
    
    @Override
    public MovieSession add(MovieSession session) {
        return null;
    }
}
