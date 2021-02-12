package core.util.mapper.impl;

import core.model.Movie;
import core.model.dto.MovieRequestDto;
import core.model.dto.MovieResponseDto;
import core.util.mapper.MovieMapper;

public class MovieMapperImpl implements MovieMapper {
    
    @Override
    public MovieResponseDto mapToDto(Movie movie) {
        return new MovieResponseDto(movie.getId(),
                movie.getTitle(),
                movie.getDescription());
    }
    
    @Override
    public Movie mapFromDto(MovieRequestDto movieRequestDto) {
        return new Movie(movieRequestDto.getTitle(),
                movieRequestDto.getDescription());
    }
}
