package core.service;

import core.dao.MovieDao;
import core.lib.Inject;
import core.lib.Service;
import core.model.Movie;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    
    @Inject
    private MovieDao dao;
    
    @Override
    public Movie add(Movie movie) {
        return dao.add(movie);
    }
    
    @Override
    public List<Movie> getAll() {
        return dao.getAll();
    }
}
