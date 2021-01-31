package core.dao.impl;

import core.dao.MovieSessionDao;
import core.model.MovieSession;
import java.time.LocalDate;
import java.util.List;

public class MovieSessionDaoImpl implements MovieSessionDao {
    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return null;
    }
    
    @Override
    public MovieSession add(MovieSession session) {
        return null;
    }
}
