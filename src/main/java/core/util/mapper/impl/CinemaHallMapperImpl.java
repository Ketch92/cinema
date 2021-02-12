package core.util.mapper.impl;

import core.model.CinemaHall;
import core.model.dto.CinemaHallRequestDto;
import core.model.dto.CinemaHallResponseDto;
import core.util.mapper.CinemaHallMapper;

public class CinemaHallMapperImpl implements CinemaHallMapper {
    @Override
    public CinemaHallResponseDto mapToDto(CinemaHall cinemaHall) {
        return new CinemaHallResponseDto(cinemaHall.getId(),
                cinemaHall.getCapacity(),
                cinemaHall.getDescription());
    }
    
    @Override
    public CinemaHall mapFromDto(CinemaHallRequestDto cinemaHallRequestDto) {
        return new CinemaHall(cinemaHallRequestDto.getCapacity(),
                cinemaHallRequestDto.getDescription());
    }
}
