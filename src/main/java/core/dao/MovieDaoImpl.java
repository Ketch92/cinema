package core.dao;

import core.lib.Dao;
import core.model.Movie;
import core.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Dao
public class MovieDaoImpl implements MovieDao {
    @Override
    public Movie add(Movie movie) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(movie);
            transaction.commit();
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
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Query<Movie> allMovies = session.createQuery("from Movie", Movie.class);
            return allMovies.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get all movies from DB");
        }
    }
}
