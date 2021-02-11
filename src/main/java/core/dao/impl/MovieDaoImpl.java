package core.dao.impl;

import core.dao.MovieDao;
import core.model.Movie;
import java.util.List;
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
    public List<Movie> getAll() {
        return super.getAll(Movie.class);
    }
}
