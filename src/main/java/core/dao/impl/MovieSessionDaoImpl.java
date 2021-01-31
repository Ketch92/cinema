package core.dao.impl;

import core.dao.MovieSessionDao;
import core.lib.Inject;
import core.lib.Service;
import core.model.MovieSession;
import java.time.LocalDate;
import java.util.List;

@Service
public class MovieSessionDaoImpl implements MovieSessionDao {
    
    @Inject
    private MovieSessionDao movieSessionDao;
    
    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return movieSessionDao.findAvailableSessions(movieId, date);
    }
    
    @Override
    public MovieSession add(MovieSession session) {
        return movieSessionDao.add(session);
    }
}
