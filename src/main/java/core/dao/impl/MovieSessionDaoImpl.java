package core.dao.impl;

import core.dao.MovieSessionDao;
import core.lib.Dao;
import core.model.MovieSession;
import core.model.exception.DataProcessingException;
import core.util.HibernateUtils;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class MovieSessionDaoImpl extends AbstractDao<MovieSession> implements MovieSessionDao {
    
    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<MovieSession> query = criteriaBuilder.createQuery(MovieSession.class);
            
            Root<MovieSession> movieSessionRoot = query.from(MovieSession.class);
            movieSessionRoot.fetch("movie", JoinType.INNER);
            movieSessionRoot.fetch("cinemaHall", JoinType.INNER);
            
            Predicate idPredicate = criteriaBuilder
                    .equal(movieSessionRoot.get("movie"), movieId);
            Predicate dateFromPredicate = criteriaBuilder
                    .greaterThanOrEqualTo(movieSessionRoot.get("showTime"),
                            date.atTime(LocalTime.now()));
            Predicate dateToPredicate = criteriaBuilder
                    .lessThanOrEqualTo(movieSessionRoot.get("showTime"),
                            date.atTime(LocalTime.of(23, 59, 59)));
            
            query.select(movieSessionRoot).where(criteriaBuilder
                    .and(idPredicate, dateFromPredicate, dateToPredicate));
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Errored while retrieving data from DB", e);
        }
    }
    
    @Override
    public MovieSession add(MovieSession movieSession) {
        return super.create(movieSession, HibernateUtils.getSessionFactory());
    }
}
