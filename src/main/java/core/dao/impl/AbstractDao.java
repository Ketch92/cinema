package core.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public abstract class AbstractDao<T> {
    public T create(T entity, SessionFactory factory) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
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
    
    public T get(Class<T> clazz, Long id, SessionFactory factory) {
        try (Session session = factory.openSession()) {
            return session.get(clazz, id);
        } catch (Exception e) {
            throw new RuntimeException("Errored while retrieving data by id "
                                       + id + " from DB", e);
        }
    }
    
    public List<T> getAll(Class<T> clazz, SessionFactory factory) {
        try (Session session = factory.openSession()) {
            Query<T> allUsers = session.createQuery("from " + clazz.getSimpleName(), clazz);
            return allUsers.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Errored while retrieving all data from DB");
        }
    }
    
    public void remove(T entity, SessionFactory factory) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Errored while deleting data "
                                       + entity + " from DB");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
