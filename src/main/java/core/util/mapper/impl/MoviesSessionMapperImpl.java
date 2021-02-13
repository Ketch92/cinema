package core.util.mapper.impl;

import core.model.CinemaHall;
import core.model.Movie;
import core.model.MovieSession;
import core.model.dto.MovieSessionRequestDto;
import core.model.dto.MovieSessionResponseDto;
import core.service.CinemaHallService;
import core.service.MovieService;
import core.util.mapper.MovieSessionMapper;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class MoviesSessionMapperImpl implements MovieSessionMapper {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;
    
    public MoviesSessionMapperImpl(MovieService movieService,
                                   CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }
    
    @Override
    public MovieSessionResponseDto mapToDto(MovieSession movieSession) {
        return new MovieSessionResponseDto(movieSession.getId(),
                movieSession.getMovie().getTitle(),
                movieSession.getCinemaHall().getCapacity(),
                movieSession.getCinemaHall().getDescription(),
                movieSession.getShowTime());
    }
    
    @Override
    public MovieSession mapToEntity(MovieSessionRequestDto movieSessionRequestDto) {
        Movie movie = movieService.get(movieSessionRequestDto.getMovieId());
        CinemaHall cinemaHall = cinemaHallService.get(movieSessionRequestDto.getCinemaHallId());
        MovieSession movieSession = new MovieSession(movie,
                cinemaHall,
                LocalDateTime.parse(movieSessionRequestDto.getShowTime()));
        movieSession.setId(movieSessionRequestDto.getSessionId());
        return movieSession;
    }
}
