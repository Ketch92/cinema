package core.service.mapper.impl;

import core.model.ShoppingCart;
import core.model.Ticket;
import core.model.dto.ShoppingCartResponseDto;
import core.service.mapper.ToDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper implements ToDtoMapper<ShoppingCartResponseDto, ShoppingCart> {
    @Override
    public ShoppingCartResponseDto mapToDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto responseDto = new ShoppingCartResponseDto();
        responseDto.setId(shoppingCart.getId());
        List<Long> tickets = shoppingCart.getTicketList().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList());
        responseDto.setTickets(tickets);
        return responseDto;
    }
}
