package core.model.dto;

import javax.validation.constraints.NotNull;

public class MovieSessionRequestDto {
    @NotNull(message = "Please, don't leave this field empty.")
    private Long movieId;
    @NotNull(message = "Please, don't leave this field empty.")
    private Long cinemaHallId;
    @NotNull(message = "Please, don't leave this field empty.")
    private String showTime;
    
    public Long getMovieId() {
        return movieId;
    }
    
    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
    
    public Long getCinemaHallId() {
        return cinemaHallId;
    }
    
    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }
    
    public String getShowTime() {
        return showTime;
    }
    
    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
    
    @Override
    public String toString() {
        return "MovieSessionRequestDto{"
               + "movieId=" + movieId
               + ", cinemaHallId=" + cinemaHallId
               + ", showTime=" + showTime
               + '}';
    }
}
