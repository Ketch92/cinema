package core.util.mapper.impl;

import core.model.Movie;
import core.model.dto.MovieRequestDto;
import core.model.dto.MovieResponseDto;
import core.util.mapper.MovieMapper;
import org.springframework.stereotype.Component;

@Component
public class MovieMapperImpl implements MovieMapper {
    @Override
    public MovieResponseDto mapToDto(Movie movie) {
        MovieResponseDto dto = new MovieResponseDto();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setDescription(movie.getDescription());
        return dto;
    }
    
    @Override
    public Movie mapToEntity(MovieRequestDto movieRequestDto) {
        return new Movie(movieRequestDto.getTitle(),
                movieRequestDto.getDescription());
    }
}
