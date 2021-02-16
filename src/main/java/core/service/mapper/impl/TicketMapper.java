package core.service.mapper.impl;

import core.model.MovieSession;
import core.model.Ticket;
import core.model.User;
import core.model.dto.MovieSessionResponseDto;
import core.model.dto.TicketResponseDto;
import core.model.dto.UserResponseDto;
import core.service.mapper.ToDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper implements ToDtoMapper<TicketResponseDto, Ticket> {
    private ToDtoMapper<MovieSessionResponseDto, MovieSession> movieSessionToDtoMapper;
    private ToDtoMapper<UserResponseDto, User> userToDtoMapper;
    
    public TicketMapper(ToDtoMapper<MovieSessionResponseDto, MovieSession> movieSessionToDtoMapper,
                        ToDtoMapper<UserResponseDto, User> userToDtoMapper) {
        this.movieSessionToDtoMapper = movieSessionToDtoMapper;
        this.userToDtoMapper = userToDtoMapper;
    }
    
    @Override
    public TicketResponseDto mapToDto(Ticket ticket) {
        TicketResponseDto responseDto = new TicketResponseDto();
        responseDto.setTicketId(ticket.getId());
        responseDto.setSessionResponseDto(movieSessionToDtoMapper.mapToDto(ticket.getMovieSession()));
        responseDto.setUserResponseDto(userToDtoMapper.mapToDto(ticket.getUser()));
        return responseDto;
    }
}
