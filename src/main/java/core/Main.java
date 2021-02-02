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
    private static final Injector INJECTOR
            = Injector.getInstance(Main.class.getPackageName());
    private static final MovieService MOVIE_SERVICE
            = (MovieService) INJECTOR.getInstance(MovieService.class);
    private static final CinemaHallService CINEMA_HALL_SERVICE
            = (CinemaHallService) INJECTOR.getInstance(CinemaHallService.class);
    private static final MovieSessionService SESSION_SERVICE
            = (MovieSessionService) INJECTOR.getInstance(MovieSessionService.class);
    private static final AuthenticationService AUTHENTICATION_SERVICE =
            (AuthenticationService) INJECTOR.getInstance(AuthenticationService.class);
    
    public static void main(String[] args) throws AuthenticationException {
        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");
        MOVIE_SERVICE.add(movie);
        MOVIE_SERVICE.getAll().forEach(System.out::println);
    
        System.out.println("\n=============================\n");

        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(100);
        cinemaHall.setDescription("4DX big hole");
        CINEMA_HALL_SERVICE.add(cinemaHall);
        CINEMA_HALL_SERVICE.getAll().forEach(System.out::println);
    
        MovieSession session1 = new MovieSession();
        session1.setMovie(movie);
        session1.setCinemaHall(cinemaHall);
        session1.setShowTime(LocalDateTime.now().plusHours(1));
    
        MovieSession session2 = new MovieSession();
        session2.setMovie(movie);
        session2.setCinemaHall(cinemaHall);
        session2.setShowTime(LocalDateTime.now().plusHours(24));
        
        MovieSessionService movieSessionService
                = (MovieSessionService) INJECTOR.getInstance(MovieSessionService.class);
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
        
        User user = AUTHENTICATION_SERVICE.register(userEmail, userPassword);
        User anotherUser = AUTHENTICATION_SERVICE.register(anotherUserEmail,
                anotherUserPsw);
        User loggedUser = AUTHENTICATION_SERVICE.login(anotherUserEmail,
                anotherUserPsw);
        System.out.println("Is registered user logged in " + anotherUser.equals(loggedUser));
    }
}
