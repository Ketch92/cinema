package core.service.impl;

import core.dao.MovieDao;
import core.lib.Inject;
import core.lib.Service;
import core.model.Movie;
import core.service.MovieService;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Inject
    private MovieDao movieDao;
    
    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }
    
    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
