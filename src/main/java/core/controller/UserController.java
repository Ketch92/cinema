package core.controller;

import core.model.User;
import core.model.dto.UserResponseDto;
import core.model.exception.DataProcessingException;
import core.service.UserService;
import core.service.mapper.ToDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userService;
    private final ToDtoMapper<UserResponseDto, User> toDtoMapper;
    
    public UserController(UserService userService,
                          ToDtoMapper<UserResponseDto, User> toDtoMapper) {
        this.userService = userService;
        this.toDtoMapper = toDtoMapper;
    }
    
    @GetMapping("/by-email")
    public UserResponseDto getUserByEmail(@RequestParam String email) {
        return toDtoMapper.mapToDto(userService.findByEmail(email)
                .orElseThrow(() -> new DataProcessingException("No user with such email!")));
    }
}
