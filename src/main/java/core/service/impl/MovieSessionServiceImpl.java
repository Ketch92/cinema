package core.service.impl;

import core.dao.MovieSessionDao;
import core.lib.Inject;
import core.lib.Service;
import core.model.MovieSession;
import core.service.MovieSessionService;
import java.time.LocalDate;
import java.util.List;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
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
