package core.service.impl;

import core.dao.MovieDao;
import core.model.Movie;
import core.service.MovieService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieDao movieDao;
    
    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }
    
    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }
    
    @Override
    public Movie get(Long id) {
        return movieDao.get(id).orElseThrow();
    }
    
    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
