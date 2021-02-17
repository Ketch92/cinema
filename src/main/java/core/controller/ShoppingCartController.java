package core.controller;

import core.model.MovieSession;
import core.model.ShoppingCart;
import core.model.User;
import core.model.dto.ShoppingCartResponseDto;
import core.service.MovieSessionService;
import core.service.ShoppingCartService;
import core.service.UserService;
import core.service.mapper.ToDtoMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
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
    public ShoppingCartResponseDto getShoppingCartsByUser(Authentication authentication) {
        UserDetails details = (UserDetails) authentication.getPrincipal();
        User user = userService.findByEmail(details.getUsername()).get();
        return cartToDtoMapper.mapToDto(shoppingCartService.getByUser(user));
    }
    
    @PostMapping("/movie-sessions")
    public String addSessionToCart(@RequestParam Long movieSessionId, Authentication authentication) {
        UserDetails details = (UserDetails) authentication.getPrincipal();
        User user = userService.findByEmail(details.getUsername()).get();
        MovieSession movieSession = movieSessionService.get(movieSessionId);
        shoppingCartService.addSession(movieSession, user);
        return "The movie session was placed to your cart.";
    }
}
