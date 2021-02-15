package core.util.mapper.impl;

import core.model.CinemaHall;
import core.model.dto.CinemaHallRequestDto;
import core.model.dto.CinemaHallResponseDto;
import core.util.mapper.CinemaHallMapper;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapperImpl implements CinemaHallMapper {
    @Override
    public CinemaHallResponseDto mapToDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto responseDto = new CinemaHallResponseDto();
        chrDto.setId(cinemaHall.getId());
        chrDto.setCapacity(cinemaHall.getCapacity());
        chrDto.setDescription(cinemaHall.getDescription());
        return chrDto;
    }
    
    @Override
    public CinemaHall mapToEntity(CinemaHallRequestDto cinemaHallRequestDto) {
        return new CinemaHall(cinemaHallRequestDto.getCapacity(),
                cinemaHallRequestDto.getDescription());
    }
}
