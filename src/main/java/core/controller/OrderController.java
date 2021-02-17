package core.controller;

import core.model.Order;
import core.model.User;
import core.model.dto.OrderResponseDto;
import core.service.OrderService;
import core.service.ShoppingCartService;
import core.service.UserService;
import core.service.mapper.ToDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final ToDtoMapper<OrderResponseDto, Order> orderToDtoMapper;
    
    public OrderController(OrderService orderService,
                           UserService userService,
                           ShoppingCartService shoppingCartService,
                           ToDtoMapper<OrderResponseDto, Order> orderToDtoMapper) {
        this.orderService = orderService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.orderToDtoMapper = orderToDtoMapper;
    }
    
    @GetMapping("/orders")
    public List<OrderResponseDto> getUserOrders(Authentication authentication) {
        UserDetails details = (UserDetails) authentication.getPrincipal();
        User user = userService.findByEmail(details.getUsername()).get();
        return orderService.getOrdersHistory(userService.get(user.getId())).stream()
                .map(orderToDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }
    
    @PostMapping("/complete")
    public OrderResponseDto completeOrder(Authentication authentication) {
        UserDetails details = (UserDetails) authentication.getPrincipal();
        User user = userService.findByEmail(details.getUsername()).get();
        Order order = orderService.completeOrder(shoppingCartService.getByUser(user));
        return orderToDtoMapper.mapToDto(order);
    }
}
