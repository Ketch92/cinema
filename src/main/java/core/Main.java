package core;

import core.lib.Injector;
import core.model.CinemaHall;
import core.model.Movie;
import core.model.MovieSession;
import core.service.CinemaHallService;
import core.service.MovieService;
import core.service.MovieSessionService;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    private static Injector injector = Injector.getInstance(Main.class.getPackageName());
    
    public static void main(String[] args) {
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        
        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");
        movieService.add(movie);
        movieService.getAll().forEach(System.out::println);
    
        CinemaHallService cinemaHallService
                = (CinemaHallService) injector.getInstance(CinemaHallService.class);
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
    }
}
