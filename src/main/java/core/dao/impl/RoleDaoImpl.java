package core.dao.impl;

import core.dao.RoleDao;
import core.model.Role;
import core.model.exception.DataProcessingException;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    
    @Override
    public Role add(Role role) {
        return super.create(role);
    }
    
    @Override
    public Optional<Role> getRoleByName(String roleName) {
        try (Session session = getSessionFactory().openSession()) {
            Query<Role> query = session.createQuery("from Role r"
                                                    + " where r.roleName = :roleName", Role.class);
            query.setParameter("roleName", roleName);
            return query.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Failed to retrieve the "
                                              + roleName + "from DB");
        }
    }
}
