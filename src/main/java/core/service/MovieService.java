package core.service;

import core.model.Movie;
import java.util.List;

public interface MovieService {
    Movie add(Movie movie);
    
    List<Movie> getAll();
}
