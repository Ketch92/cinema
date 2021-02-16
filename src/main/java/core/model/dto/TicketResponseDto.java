package core.model.dto;

public class TicketResponseDto {
    private Long ticketId;
    private MovieSessionResponseDto sessionResponseDto;
    private UserResponseDto userResponseDto;
    
    public Long getTicketId() {
        return ticketId;
    }
    
    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }
    
    public MovieSessionResponseDto getSessionResponseDto() {
        return sessionResponseDto;
    }
    
    public void setSessionResponseDto(MovieSessionResponseDto sessionResponseDto) {
        this.sessionResponseDto = sessionResponseDto;
    }
    
    public UserResponseDto getUserResponseDto() {
        return userResponseDto;
    }
    
    public void setUserResponseDto(UserResponseDto userResponseDto) {
        this.userResponseDto = userResponseDto;
    }
    
    @Override
    public String toString() {
        return "TicketResponseDto{"
               + "ticketId=" + ticketId
               + ", sessionResponseDto=" + sessionResponseDto
               + ", userResponseDto=" + userResponseDto
               + '}';
    }
}
