package core.controller;

import core.model.MovieSession;
import core.model.dto.MovieSessionRequestDto;
import core.model.dto.MovieSessionResponseDto;
import core.service.MovieSessionService;
import core.service.mapper.ToDtoMapper;
import core.service.mapper.ToEntityMapper;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/movie-sessions")
@RestController
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final ToDtoMapper<MovieSessionResponseDto, MovieSession> toDtoMapper;
    private final ToEntityMapper<MovieSession, MovieSessionRequestDto> mapToEntity;
    
    public MovieSessionController(MovieSessionService movieSessionService, ToDtoMapper<MovieSessionResponseDto, MovieSession> toDtoMapper, ToEntityMapper<MovieSession, MovieSessionRequestDto> mapToEntity) {
        this.movieSessionService = movieSessionService;
        this.toDtoMapper = toDtoMapper;
        this.mapToEntity = mapToEntity;
    }
    
    @GetMapping("/{id}")
    public MovieSessionResponseDto get(@PathVariable Long id) {
        return toDtoMapper.mapToDto(movieSessionService.get(id));
    }
    
    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAvailable(@RequestParam Long movieId,
                                                      @RequestParam
                                                      @DateTimeFormat(pattern = "dd.MM.yyyy")
                                                              LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(toDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }
    
    @PostMapping
    public void addMovieSession(@RequestBody MovieSessionRequestDto requestDto) {
        movieSessionService.add(mapToEntity.mapToEntity(requestDto));
    }
    
    @PutMapping("/{id}")
    public void updateMovieSession(@RequestBody MovieSessionRequestDto movieSessionRequestDto,
                                   @PathVariable Long id) {
        MovieSession movieSession = mapToEntity.mapToEntity(movieSessionRequestDto);
        movieSession.setId(id);
        movieSessionService.update(movieSession);
    }
    
    @DeleteMapping("/{id}")
    public void deleteMovieSession(@PathVariable Long id) {
        movieSessionService.delete(id);
    }
}
