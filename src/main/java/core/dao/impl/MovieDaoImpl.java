package core.dao.impl;

import core.dao.MovieDao;
import core.lib.Dao;
import core.model.Movie;
import core.util.HibernateUtils;
import java.util.List;

@Dao
public class MovieDaoImpl extends AbstractDao<Movie> implements MovieDao {
    @Override
    public Movie add(Movie movie) {
        return super.create(movie, HibernateUtils.getSessionFactory());
    }
    
    @Override
    public List<Movie> getAll() {
        return super.getAll(Movie.class, HibernateUtils.getSessionFactory());
    }
}
