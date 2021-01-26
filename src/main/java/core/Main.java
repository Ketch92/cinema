package core;

import core.lib.Injector;
import core.model.Movie;
import core.service.MovieService;

public class Main {
    private static Injector injector = Injector.getInstance(Main.class.getPackageName());
    
    public static void main(String[] args) {
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");
        movieService.getAll().forEach(System.out::println);
    }
}
