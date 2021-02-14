package core.model.dto;

public class MovieSessionRequestDto {
    private Long sessionId;
    private Long movieId;
    private Long cinemaHallId;
    private String showTime;
    
    public Long getSessionId() {
        return sessionId;
    }
    
    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }
    
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
