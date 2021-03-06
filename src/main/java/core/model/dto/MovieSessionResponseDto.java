package core.model.dto;

public class MovieSessionResponseDto {
    private Long id;
    private String movieTitle;
    private int cinemaHallCapacity;
    private String cinemaHallDescription;
    private String showTime;
    
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
    
    public int getCinemaHallCapacity() {
        return cinemaHallCapacity;
    }
    
    public void setCinemaHallCapacity(int cinemaHallCapacity) {
        this.cinemaHallCapacity = cinemaHallCapacity;
    }
    
    public String getCinemaHallDescription() {
        return cinemaHallDescription;
    }
    
    public void setCinemaHallDescription(String cinemaHallDescription) {
        this.cinemaHallDescription = cinemaHallDescription;
    }
    
    public String getShowTime() {
        return showTime;
    }
    
    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
    
    @Override
    public String toString() {
        return "MovieSessionResponseDto{"
               + "id=" + id
               + ", movieTitle='" + movieTitle + '\''
               + ", cinemaHallId='" + cinemaHallCapacity + '\''
               + ", cinemaHallDescription='" + cinemaHallDescription + '\''
               + ", showTime=" + showTime
               + '}';
    }
}
