package core.dao.impl;

import core.dao.MovieDao;
import core.lib.Dao;
import core.model.Movie;
import core.model.exception.DataProcessingException;
import core.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
