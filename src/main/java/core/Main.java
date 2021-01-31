package core;

import core.lib.Injector;
import core.model.CinemaHall;
import core.model.Movie;
import core.service.CinemaHallService;
import core.service.MovieService;

public class Main {
    private static Injector injector = Injector.getInstance(Main.class.getPackageName());
    
    public static void main(String[] args) {
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        CinemaHallService cinemaHallService = (CinemaHallService) injector.getInstance(CinemaHallService.class);
        
        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");
        movieService.add(movie);
        movieService.getAll().forEach(System.out::println);
    
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(100);
        cinemaHall.setDescription("4DX big hole");
        cinemaHallService.add(cinemaHall);
        cinemaHallService.getAll().forEach(System.out::println);
    }
}
