package core.controller;

import core.model.MovieSession;
import core.model.ShoppingCart;
import core.model.User;
import core.model.dto.ShoppingCartResponseDto;
import core.service.MovieSessionService;
import core.service.ShoppingCartService;
import core.service.UserService;
import core.service.mapper.ToDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/shopping-carts")
@RestController
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final MovieSessionService movieSessionService;
    private final ToDtoMapper<ShoppingCartResponseDto, ShoppingCart> cartToDtoMapper;
    
    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  MovieSessionService movieSessionService,
                                  ToDtoMapper<ShoppingCartResponseDto,
                                          ShoppingCart> cartToDtoMapper) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
        this.cartToDtoMapper = cartToDtoMapper;
    }
    
    @GetMapping("/by-user")
    public ShoppingCartResponseDto getShoppingCartsByUser(@RequestParam Long userId) {
        return cartToDtoMapper.mapToDto(shoppingCartService.get(userId));
    }
    
    @PostMapping("/movie-sessions")
    public String addSessionToCart(@RequestParam Long userId, @RequestParam Long movieSessionId) {
        MovieSession movieSession = movieSessionService.get(movieSessionId);
        User user = userService.get(userId);
        shoppingCartService.addSession(movieSession, user);
        return "The movie session was placed to your cart.";
    }
}
