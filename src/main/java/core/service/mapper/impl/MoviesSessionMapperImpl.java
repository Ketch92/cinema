package core.service.mapper.impl;

import core.model.CinemaHall;
import core.model.Movie;
import core.model.MovieSession;
import core.model.dto.MovieSessionRequestDto;
import core.model.dto.MovieSessionResponseDto;
import core.service.CinemaHallService;
import core.service.MovieService;
import core.service.mapper.ToDtoMapper;
import core.service.mapper.ToEntityMapper;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class MoviesSessionMapperImpl
        implements ToDtoMapper<MovieSessionResponseDto, MovieSession>,
        ToEntityMapper<MovieSession, MovieSessionRequestDto> {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;
    
    public MoviesSessionMapperImpl(MovieService movieService,
                                   CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }
    
    @Override
    public MovieSessionResponseDto mapToDto(MovieSession movieSession) {
        MovieSessionResponseDto responseDto = new MovieSessionResponseDto();
        responseDto.setId(movieSession.getId());
        responseDto.setMovieTitle(movieSession.getMovie().getTitle());
        responseDto.setCinemaHallCapacity(movieSession.getCinemaHall().getCapacity());
        responseDto.setCinemaHallDescription(movieSession.getCinemaHall().getDescription());
        responseDto.setShowTime(movieSession.getShowTime().toString());
        return responseDto;
    }
    
    @Override
    public MovieSession mapToEntity(MovieSessionRequestDto requestDto) {
        Movie movie = movieService.get(requestDto.getMovieId());
        CinemaHall cinemaHall = cinemaHallService.get(requestDto.getCinemaHallId());
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movie);
        movieSession.setCinemaHall(cinemaHall);
        movieSession.setShowTime(LocalDateTime.parse(requestDto.getShowTime()));
        return movieSession;
    }
}
