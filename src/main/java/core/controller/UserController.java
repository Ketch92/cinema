package core.controller;

import core.model.User;
import core.model.dto.UserResponseDto;
import core.service.UserService;
import core.service.mapper.ToDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
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
    public List<UserResponseDto> getUsersByEmail(@RequestParam String email) {
        return userService.findByEmail(email).stream()
                .map(toDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
