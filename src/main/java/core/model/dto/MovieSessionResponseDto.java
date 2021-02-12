package core.model.dto;

import java.time.LocalDateTime;

public class MovieSessionResponseDto {
    private Long id;
    private String movieTitle;
    private Long cinemaHallId;
    private String cinemaHallDescription;
    private LocalDateTime showTime;
    
    public MovieSessionResponseDto() {
    }
    
    public MovieSessionResponseDto(Long id,
                                   String movieTitle,
                                   Long cinemaHallId,
                                   String cinemaHallDescription,
                                   LocalDateTime showTime) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.cinemaHallId = cinemaHallId;
        this.cinemaHallDescription = cinemaHallDescription;
        this.showTime = showTime;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getMovieTitle() {
        return movieTitle;
    }
    
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
    
    public Long getCinemaHallId() {
        return cinemaHallId;
    }
    
    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }
    
    public String getCinemaHallDescription() {
        return cinemaHallDescription;
    }
    
    public void setCinemaHallDescription(String cinemaHallDescription) {
        this.cinemaHallDescription = cinemaHallDescription;
    }
    
    public LocalDateTime getShowTime() {
        return showTime;
    }
    
    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }
    
    @Override
    public String toString() {
        return "MovieSessionResponseDto{"
               + "id=" + id
               + ", movieTitle='" + movieTitle + '\''
               + ", cinemaHallId='" + cinemaHallId + '\''
               + ", cinemaHallDescription='" + cinemaHallDescription + '\''
               + ", showTime=" + showTime
               + '}';
    }
}
