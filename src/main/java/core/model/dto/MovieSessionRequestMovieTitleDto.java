package core.model.dto;

import java.time.LocalDateTime;

public class MovieSessionRequestMovieTitleDto {
    private String movieTitle;
    private Long cinemaHallId;
    private LocalDateTime showTime;
    
    public MovieSessionRequestMovieTitleDto() {
    }
    
    public MovieSessionRequestMovieTitleDto(String movieTitle,
                                            Long cinemaHallId,
                                            LocalDateTime showTime) {
        this.movieTitle = movieTitle;
        this.cinemaHallId = cinemaHallId;
        this.showTime = showTime;
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
    
    public LocalDateTime getShowTime() {
        return showTime;
    }
    
    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }
}
