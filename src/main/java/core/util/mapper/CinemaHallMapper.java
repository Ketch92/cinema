package core.util.mapper;

import core.model.CinemaHall;
import core.model.dto.CinemaHallRequestDto;
import core.model.dto.CinemaHallResponseDto;

public interface CinemaHallMapper
        extends GenericMapper<CinemaHallResponseDto,
        CinemaHallRequestDto,
        CinemaHall> {
}
