package core.controller;

import core.model.CinemaHall;
import core.model.dto.CinemaHallRequestDto;
import core.model.dto.CinemaHallResponseDto;
import core.service.CinemaHallService;
import core.service.mapper.ToDtoMapper;
import core.service.mapper.ToEntityMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
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
    private final ToDtoMapper<CinemaHallResponseDto, CinemaHall> mapToDto;
    private final ToEntityMapper<CinemaHall, CinemaHallRequestDto> mapToEntity;
    
    public CinemaHallController(CinemaHallService cinemaHallService,
                                ToDtoMapper<CinemaHallResponseDto, CinemaHall> mapToDto,
                                ToEntityMapper<CinemaHall, CinemaHallRequestDto> mapToEntity) {
        this.cinemaHallService = cinemaHallService;
        this.mapToDto = mapToDto;
        this.mapToEntity = mapToEntity;
    }
    
    @GetMapping
    public List<CinemaHallResponseDto> getCinemaHalls() {
        return cinemaHallService.getAll().stream()
                .map(mapToDto::mapToDto)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public CinemaHallResponseDto getCinemaHall(@PathVariable Long id) {
        return mapToDto.mapToDto(cinemaHallService.get(id));
    }
    
    @PostMapping
    public void addCinemaHall(@RequestBody @Valid CinemaHallRequestDto requestDto) {
        cinemaHallService.add(mapToEntity.mapToEntity(requestDto));
    }
}
