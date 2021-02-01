package core;

import core.lib.Injector;
import core.model.CinemaHall;
import core.model.Movie;
import core.model.MovieSession;
import core.model.User;
import core.model.exception.AuthenticationException;
import core.service.AuthenticationService;
import core.service.CinemaHallService;
import core.service.MovieService;
import core.service.MovieSessionService;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    private static final Injector injector
            = Injector.getInstance(Main.class.getPackageName());
    private static final MovieService movieService
            = (MovieService) injector.getInstance(MovieService.class);
    private static final CinemaHallService cinemaHallService
            = (CinemaHallService) injector.getInstance(CinemaHallService.class);
    private static final AuthenticationService authenticationService =
            (AuthenticationService) injector.getInstance(AuthenticationService.class);
    
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
        
        MovieSessionService movieSessionService
                = (MovieSessionService) injector.getInstance(MovieSessionService.class);
        movieSessionService.add(session1);
        movieSessionService.add(session2);
        System.out.println("\n//print all available sessions ----------------------\n");
        movieSessionService.findAvailableSessions(movie.getId(), LocalDate.now())
                .forEach(System.out::println);
    
        System.out.println("\n=============================\n");
        
        User user = new User();
        user.setEmail("user.email@email.com");
        user.setPassword("strong_password");
        
        User anotherUser = new User();
        String anotherUserEmail = "another@email.com";
        String anotherUserPsw = "ghadghfdas";
        anotherUser.setEmail(anotherUserEmail);
        anotherUser.setPassword(anotherUserPsw);
        
        user = authenticationService.register(user.getEmail(), user.getPassword());
        anotherUser = authenticationService.register(anotherUser.getEmail(),
                anotherUser.getPassword());
        User loggedUser = authenticationService.login(anotherUser.getEmail(),
                anotherUserPsw);
        System.out.println("Is registered user logged in " + anotherUser.equals(loggedUser));
    }
}
