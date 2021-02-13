package core.util.mapper.impl;

import core.model.CinemaHall;
import core.model.Movie;
import core.model.MovieSession;
import core.model.dto.MovieSessionRequestDto;
import core.model.dto.MovieSessionResponseDto;
import core.service.CinemaHallService;
import core.service.MovieService;
import core.util.mapper.MovieSessionMapper;
import org.springframework.stereotype.Component;

@Component
public class MoviesSessionMapperImpl implements MovieSessionMapper {
    private MovieService movieService;
    private CinemaHallService cinemaHallService;
    
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
    public MovieSession mapFromDto(MovieSessionRequestDto movieSessionRequestDto) {
        Movie movie = movieService.get(movieSessionRequestDto.getMovieId());
        CinemaHall cinemaHall = cinemaHallService.get(movieSessionRequestDto.getCinemaHallId());
        MovieSession movieSession = new MovieSession(movie,
                cinemaHall,
                movieSessionRequestDto.getShowTime());
        return movieSession;
    }
}
