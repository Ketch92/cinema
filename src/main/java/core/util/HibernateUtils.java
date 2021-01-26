package core.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory sessionFactory = initSessionFactory();
    
    private static SessionFactory initSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            throw new RuntimeException("Errored while creating the SessionFactory");
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
