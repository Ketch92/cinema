package core.model;

import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    private Long id;
    @OneToMany
    @JoinTable(name = "tickets_cats",
            joinColumns = {@JoinColumn(name = "cart_id")},
            inverseJoinColumns = {@JoinColumn(name = "ticket_id")}
    )
    private List<Ticket> ticketList;
    @OneToOne
    @MapsId
    private User user;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public List<Ticket> getTicketList() {
        return ticketList;
    }
    
    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    @Override
    public String toString() {
        return "ShoppingCart{"
               + "id=" + id
               + ", ticketList=" + ticketList
               + ", user=" + user
               + '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(id, that.id)
               && Objects.equals(ticketList, that.ticketList)
               && Objects.equals(user, that.user);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, ticketList, user);
    }
}
