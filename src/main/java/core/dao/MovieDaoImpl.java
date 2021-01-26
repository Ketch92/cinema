package core.dao;

import core.lib.Dao;
import core.model.Movie;
import core.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class MovieDaoImpl implements MovieDao {
    @Override
    public Movie add(Movie movie) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.getTransaction();
            Long movieId = (Long) session.save(movie);
            transaction.commit();
            movie.setId(movieId);
            return movie;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to insert movie"
                                       + movie.getTitle() + "to DB", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    @Override
    public List<Movie> getAll() {
        return null;
    }
}
