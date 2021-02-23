package core.dao.impl;

import core.model.exception.DataProcessingException;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

public abstract class AbstractDao<T> {
    private final SessionFactory sessionFactory;
    
    public AbstractDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public T create(T entity) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
            return entity;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Errored while adding " + entity + " to DB", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public Optional<T> get(Class<T> clazz, Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(clazz, id));
        } catch (Exception e) {
            throw new RuntimeException("Errored while retrieving data by id "
                                       + id + " from DB", e);
        }
    }
    
    public List<T> getAll(Class<T> clazz) {
        try (Session session = sessionFactory.openSession()) {
            Query<T> allUsers = session.createQuery("from " + clazz.getSimpleName(), clazz);
            return allUsers.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Errored while retrieving all data from DB");
        }
    }
    
    public void delete(Long id, Class<T> clazz) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("delete from "
                                              + clazz.getSimpleName()
                                              + " c where c.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Errored while deleting data "
                                       + clazz.getSimpleName() + " from DB");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public void update(T entity) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new DataProcessingException("Couldn't update the " + entity, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
