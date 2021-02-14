package core.dao.impl;

import core.dao.MovieDao;
import core.model.Movie;
import java.util.List;
import java.util.Optional;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDaoImpl extends AbstractDao<Movie> implements MovieDao {
    public MovieDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    
    @Override
    public Movie add(Movie movie) {
        return super.create(movie);
    }
    
    @Override
    public Optional<Movie> get(Long id) {
        return super.get(Movie.class, id);
    }
    
    @Override
    public List<Movie> getAll() {
        return super.getAll(Movie.class);
    }
}
