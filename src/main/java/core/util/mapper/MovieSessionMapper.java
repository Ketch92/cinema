package core.util.mapper;

import core.model.MovieSession;
import core.model.dto.MovieSessionRequestDto;
import core.model.dto.MovieSessionResponseDto;

public interface MovieSessionMapper
        extends GenericMapper<MovieSessionResponseDto,
        MovieSessionRequestDto,
        MovieSession> {
}
