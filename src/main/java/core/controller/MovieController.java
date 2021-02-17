package core.controller;

import core.model.Movie;
import core.model.dto.MovieRequestDto;
import core.model.dto.MovieResponseDto;
import core.service.MovieService;
import core.service.mapper.ToDtoMapper;
import core.service.mapper.ToEntityMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/movies")
@RestController
public class MovieController {
    private final MovieService movieService;
    private final ToDtoMapper<MovieResponseDto, Movie> toDtoMapper;
    private final ToEntityMapper<Movie, MovieRequestDto> toEntityMapper;
    
    public MovieController(MovieService movieService,
                           ToDtoMapper<MovieResponseDto, Movie> toDtoMapper,
                           ToEntityMapper<Movie, MovieRequestDto> movieMapper) {
        this.movieService = movieService;
        this.toDtoMapper = toDtoMapper;
        this.toEntityMapper = movieMapper;
    }
    
    @GetMapping
    public List<MovieResponseDto> getMovies() {
        return movieService.getAll().stream()
                .map(toDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public MovieResponseDto getMovie(@PathVariable Long id) {
        return toDtoMapper.mapToDto(movieService.get(id));
    }
    
    @PostMapping
    public void addMovie(@RequestBody MovieRequestDto requestDto) {
        movieService.add(toEntityMapper.mapToEntity(requestDto));
    }
}
