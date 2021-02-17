package core.service.mapper.impl;

import core.model.CinemaHall;
import core.model.dto.CinemaHallRequestDto;
import core.model.dto.CinemaHallResponseDto;
import core.service.mapper.ToDtoMapper;
import core.service.mapper.ToEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper
        implements ToDtoMapper<CinemaHallResponseDto, CinemaHall>,
        ToEntityMapper<CinemaHall, CinemaHallRequestDto> {
    @Override
    public CinemaHallResponseDto mapToDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto responseDto = new CinemaHallResponseDto();
        responseDto.setId(cinemaHall.getId());
        responseDto.setCapacity(cinemaHall.getCapacity());
        responseDto.setDescription(cinemaHall.getDescription());
        return responseDto;
    }
    
    @Override
    public CinemaHall mapToEntity(CinemaHallRequestDto requestDto) {
        return new CinemaHall(requestDto.getCapacity(),
                requestDto.getDescription());
    }
}
