package core.service.mapper.impl;

import core.model.User;
import core.model.dto.UserResponseDto;
import core.service.mapper.ToDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements ToDtoMapper<UserResponseDto, User> {
    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setEmail(user.getEmail());
        return responseDto;
    }
}
