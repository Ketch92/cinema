package core.service.mapper;

import core.model.Movie;
import core.model.dto.MovieRequestDto;
import core.model.dto.MovieResponseDto;

public interface MovieMapper
        extends GenericMapper<MovieResponseDto,
        MovieRequestDto,
        Movie> {
}
