package core.controller;

import core.model.dto.CinemaHallRequestDto;
import core.model.dto.CinemaHallResponseDto;
import core.service.CinemaHallService;
import core.service.mapper.CinemaHallMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cinema-halls")
@RestController
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final CinemaHallMapper cinemaHallMapper;
    
    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallMapper cinemaHallMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallMapper = cinemaHallMapper;
    }
    
    @GetMapping
    public List<CinemaHallResponseDto> getCinemaHalls() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallMapper::mapToDto)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public CinemaHallResponseDto getCinemaHall(@PathVariable Long id) {
        return cinemaHallMapper.mapToDto(cinemaHallService.get(id));
    }
    
    @PostMapping
    public void addCinemaHall(@RequestBody CinemaHallRequestDto requestDto) {
        cinemaHallService.add(cinemaHallMapper.mapToEntity(requestDto));
    }
}
