package core;

import core.lib.Injector;
import core.model.CinemaHall;
import core.model.Movie;
import core.model.MovieSession;
import core.model.ShoppingCart;
import core.model.User;
import core.model.exception.AuthenticationException;
import core.security.AuthenticationService;
import core.service.CinemaHallService;
import core.service.MovieService;
import core.service.MovieSessionService;
import core.service.OrderService;
import core.service.ShoppingCartService;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    private static final Injector injector
            = Injector.getInstance(Main.class.getPackageName());
    private static final MovieService movieService
            = (MovieService) injector.getInstance(MovieService.class);
    private static final MovieSessionService movieSessionService
            = (MovieSessionService) injector.getInstance(MovieSessionService.class);
    private static final CinemaHallService cinemaHallService
            = (CinemaHallService) injector.getInstance(CinemaHallService.class);
    private static final MovieSessionService sessionService
            = (MovieSessionService) injector.getInstance(MovieSessionService.class);
    private static final AuthenticationService authenticationService
            = (AuthenticationService) injector.getInstance(AuthenticationService.class);
    private static final ShoppingCartService shoppingCartService
            = (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
    private static final OrderService orderService
            = (OrderService) injector.getInstance(OrderService.class);
    
    public static void main(String[] args) throws AuthenticationException {
        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");
        movieService.add(movie);
        movieService.getAll().forEach(System.out::println);
    
        System.out.println("\n=============================\n");

        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(100);
        cinemaHall.setDescription("4DX big hole");
        cinemaHallService.add(cinemaHall);
        cinemaHallService.getAll().forEach(System.out::println);
    
        MovieSession session1 = new MovieSession();
        session1.setMovie(movie);
        session1.setCinemaHall(cinemaHall);
        session1.setShowTime(LocalDateTime.now().plusHours(1));
    
        MovieSession session2 = new MovieSession();
        session2.setMovie(movie);
        session2.setCinemaHall(cinemaHall);
        session2.setShowTime(LocalDateTime.now().plusHours(24));
        
        movieSessionService.add(session1);
        movieSessionService.add(session2);
        System.out.println("\n//print all available sessions ----------------------\n");
        movieSessionService.findAvailableSessions(movie.getId(), LocalDate.now())
                .forEach(System.out::println);
    
        System.out.println("\n=============================\n");
        
        String userEmail = "user.email@email.com";
        String userPassword = "strong_password";
        
        String anotherUserEmail = "another@email.com";
        String anotherUserPsw = "ghadghfdas";
        
        User user = authenticationService.register(userEmail, userPassword);
        User anotherUser = authenticationService.register(anotherUserEmail,
                anotherUserPsw);
        User loggedUser = authenticationService.login(anotherUserEmail,
                anotherUserPsw);
        System.out.println("Is registered user logged in " + anotherUser.equals(loggedUser));
    
        System.out.println("\n=============================\n");
    
        ShoppingCart byUser = shoppingCartService.getByUser(loggedUser);
        System.out.println(byUser);
        shoppingCartService.addSession(session1, loggedUser);
        byUser = shoppingCartService.getByUser(loggedUser);
        System.out.println(byUser);
        
        System.out.println("\n=============================\n");
        
        orderService.completeOrder(byUser);
        orderService.getOrdersHistory(loggedUser).forEach(System.out::println);
    }
}
