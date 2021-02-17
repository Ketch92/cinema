package core.model.dto;

public class TicketResponseDto {
    private Long ticketId;
    private MovieSessionResponseDto moviesSession;
    private UserResponseDto user;
    
    public Long getTicketId() {
        return ticketId;
    }
    
    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }
    
    public MovieSessionResponseDto getMoviesSession() {
        return moviesSession;
    }
    
    public void setMoviesSession(MovieSessionResponseDto moviesSession) {
        this.moviesSession = moviesSession;
    }
    
    public UserResponseDto getUser() {
        return user;
    }
    
    public void setUser(UserResponseDto user) {
        this.user = user;
    }
    
    @Override
    public String toString() {
        return "TicketResponseDto{"
               + "ticketId=" + ticketId
               + ", sessionResponseDto=" + moviesSession
               + ", userResponseDto=" + user
               + '}';
    }
}
