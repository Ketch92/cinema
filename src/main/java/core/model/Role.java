package core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;
    
    public Role() {
    }
    
    public Role(String authority) {
        this.authority = authority;
    }
    
    @Override
    public String getAuthority() {
        return null;
    }
    
    public void setAuthority(String authority) {
        this.authority = authority;
    }
    
    @Override
    public String toString() {
        return "Role{"
               + "authority='" + authority + '\''
               + '}';
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Id
    public Long getId() {
        return id;
    }
}
