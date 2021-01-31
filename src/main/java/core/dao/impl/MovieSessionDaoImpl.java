package core.dao.impl;

import core.dao.MovieSessionDao;
import core.lib.Dao;
import core.model.CinemaHall;
import core.model.Movie;
import core.model.MovieSession;
import core.model.exception.DataProcessingException;
import core.util.HibernateUtils;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class MovieSessionDaoImpl implements MovieSessionDao {
    
    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<MovieSession> query = criteriaBuilder.createQuery(MovieSession.class);
            
            Root<MovieSession> movieSessionRoot = query.from(MovieSession.class);
            Join<MovieSession, CinemaHall> movieSessionCinemaHallJoin
                    = movieSessionRoot.join("MovieSession.movie_id");
            Join<MovieSession, Movie> movieSessionMovieJoin
                    = movieSessionRoot.join("MovieSession_.movie", JoinType.INNER);
            
            Predicate idPredicate = criteriaBuilder
                    .equal(movieSessionRoot.get("movie_id"), movieId);
            Predicate datePredicate = criteriaBuilder
                    .like(movieSessionRoot.get("showtime"), date.toString());
            
            query.select(movieSessionRoot).where(criteriaBuilder.and(idPredicate, datePredicate));
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Errored while retrieving data from DB", e);
        }
    }
    
    @Override
    public MovieSession add(MovieSession movieSession) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(movieSession);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null || transaction.isActive()) {
                transaction.rollback();
            }
            throw new DataProcessingException("Errored while adding the " + movieSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return movieSession;
    }
}
