package core.dao;

import core.model.Movie;
import java.util.List;

public interface MovieDao {
    Movie add(Movie movie);
    
    Movie get(Long id);
    
    List<Movie> getAll();
}
