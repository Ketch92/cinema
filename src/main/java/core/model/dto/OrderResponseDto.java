package core.model.dto;

import java.util.List;

public class OrderResponseDto {
    private Long orderId;
    private List<Long> ticketIds;
    private Long userId;
    private String orderDate;
    
    public Long getOrderId() {
        return orderId;
    }
    
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    
    public List<Long> getTickets() {
        return ticketIds;
    }
    
    public void setTickets(List<Long> tickets) {
        this.ticketIds = tickets;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getOrderDate() {
        return orderDate;
    }
    
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
