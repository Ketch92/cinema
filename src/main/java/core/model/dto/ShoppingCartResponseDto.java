package core.model.dto;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketIds;
    
    public ShoppingCartResponseDto() {
    }
    
    public ShoppingCartResponseDto(Long id, List<Long> tickets) {
        this.id = id;
        this.ticketIds = tickets;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public List<Long> getTicketIds() {
        return ticketIds;
    }
    
    public void setTicketIds(List<Long> ticketIds) {
        this.ticketIds = ticketIds;
    }
}
