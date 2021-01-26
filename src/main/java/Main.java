import core.lib.Injector;
import core.model.Movie;
import core.service.MovieService;

public class Main {
    private static Injector injector = Injector.getInstance("<YOUR_PACKAGE>");
    
    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        movieService.add(movie);
        
        movieService.getAll().forEach(System.out::println);
    }
}
