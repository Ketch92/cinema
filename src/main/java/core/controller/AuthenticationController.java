package core.controller;

import core.model.dto.UserRequestDto;
import core.model.exception.UserRegistrationException;
import core.security.AuthenticationService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    
    @PostMapping("/register")
    public void registerUser(@RequestBody @Valid UserRequestDto requestDto)
            throws UserRegistrationException {
        authenticationService.register(requestDto.getEmail(), requestDto.getPassword());
    }
}
