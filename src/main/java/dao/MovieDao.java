package dao;

import core.model.Movie;
import java.util.List;

public interface MovieDao {
    Movie add(Movie movie);
    
    List<Movie> getAll();
}
