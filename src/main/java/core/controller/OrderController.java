package core.controller;

import core.model.Order;
import core.model.dto.OrderResponseDto;
import core.service.OrderService;
import core.service.ShoppingCartService;
import core.service.UserService;
import core.service.mapper.ToDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/orders")
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
    
    @GetMapping
    public List<OrderResponseDto> getUserOrders(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.get(userId)).stream()
                .map(orderToDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }
    
    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        Order order = orderService.completeOrder(shoppingCartService.get(userId));
        return orderToDtoMapper.mapToDto(order);
    }
}