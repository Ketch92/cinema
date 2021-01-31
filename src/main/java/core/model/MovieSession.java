package core.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MovieSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private CinemaHall cinemaHall;
    private LocalDateTime showTime;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Movie getMovie() {
        return movie;
    }
    
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }
    
    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }
    
    public LocalDateTime getShowTime() {
        return showTime;
    }
    
    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }
    
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MovieSession{");
        sb.append("id=").append(id);
        sb.append(", movie=").append(movie);
        sb.append(", cinemaHall=").append(cinemaHall);
        sb.append(", showTime=").append(showTime);
        sb.append('}');
        return sb.toString();
    }
}
