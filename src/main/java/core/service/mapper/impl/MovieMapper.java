package core.service.mapper.impl;

import core.model.Movie;
import core.model.dto.MovieRequestDto;
import core.model.dto.MovieResponseDto;
import core.service.mapper.ToDtoMapper;
import core.service.mapper.ToEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper
        implements ToDtoMapper<MovieResponseDto, Movie>,
        ToEntityMapper<Movie, MovieRequestDto> {
    @Override
    public MovieResponseDto mapToDto(Movie movie) {
        MovieResponseDto responseDto = new MovieResponseDto();
        responseDto.setId(movie.getId());
        responseDto.setTitle(movie.getTitle());
        responseDto.setDescription(movie.getDescription());
        return responseDto;
    }
    
    @Override
    public Movie mapToEntity(MovieRequestDto requestDto) {
        return new Movie(requestDto.getTitle(),
                requestDto.getDescription());
    }
}
