package core.controller;

import core.model.dto.MovieRequestDto;
import core.model.dto.MovieResponseDto;
import core.service.MovieService;
import core.util.mapper.MovieMapper;
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
    private final MovieMapper movieMapper;
    
    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }
    
    @GetMapping
    public List<MovieResponseDto> getMovies() {
        return movieService.getAll().stream()
                .map(movieMapper::mapToDto)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public MovieResponseDto getMovie(@PathVariable Long id) {
        return movieMapper.mapToDto(movieService.get(id));
    }
    
    @PostMapping
    public void addMovie(@RequestBody MovieRequestDto movieRequestDto) {
        movieService.add(movieMapper.mapFromDto(movieRequestDto));
    }
}
