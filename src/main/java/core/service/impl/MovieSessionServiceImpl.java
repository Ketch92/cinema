package core.service.impl;

import core.dao.MovieSessionDao;
import core.model.MovieSession;
import core.service.MovieSessionService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    private final MovieSessionDao movieSessionDao;
    
    public MovieSessionServiceImpl(MovieSessionDao movieSessionDao) {
        this.movieSessionDao = movieSessionDao;
    }
    
    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return movieSessionDao.findAvailableSessions(movieId, date);
    }
    
    @Override
    public MovieSession get(Long id) {
        return movieSessionDao.get(id).orElseThrow();
    }
    
    @Override
    public void update(MovieSession movieSession) {
        movieSessionDao.update(movieSession);
    }
    
    @Override
    public void delete(Long id) {
        movieSessionDao.delete(id);
    }
    
    @Override
    public MovieSession add(MovieSession session) {
        return movieSessionDao.add(session);
    }
}
