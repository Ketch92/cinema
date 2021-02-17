package core.service.mapper.impl;

import core.model.Order;
import core.model.Ticket;
import core.model.User;
import core.model.dto.OrderResponseDto;
import core.model.dto.TicketResponseDto;
import core.model.dto.UserResponseDto;
import core.service.mapper.ToDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper implements ToDtoMapper<OrderResponseDto, Order> {
    private final ToDtoMapper<UserResponseDto, User> userToDtoMapper;
    private final ToDtoMapper<TicketResponseDto, Ticket> ticketToDtoMapper;
    
    public OrderMapper(ToDtoMapper<UserResponseDto, User> userToDtoMapper,
                       ToDtoMapper<TicketResponseDto, Ticket> ticketToDtoMapper) {
        this.userToDtoMapper = userToDtoMapper;
        this.ticketToDtoMapper = ticketToDtoMapper;
    }
    
    @Override
    public OrderResponseDto mapToDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setOrderId(order.getId());
        responseDto.setOrderDate(order.getOrderDate().toString());
        responseDto.setUserId(order.getUser().getId());
        List<Long> tickets = order.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList());
        responseDto.setTickets(tickets);
        return responseDto;
    }
}
