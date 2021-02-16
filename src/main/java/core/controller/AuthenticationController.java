package core.controller;

import core.model.dto.UserRequestDto;
import core.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/register")
@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    
    @PostMapping
    public String registerUser(@RequestBody UserRequestDto requestDto) {
        try {
            authenticationService.register(requestDto.getEmail(), requestDto.getPassword());
        } catch (Exception e) {
            return "The user with specified email already exists. "
                   + "Choose another email and try again!";
        }
        return "User " + requestDto.getEmail() + " was successfully registered";
    }
}
