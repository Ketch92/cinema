package core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    
    @GetMapping
    public String welcomePrint() {
        return "Welcome to Cinema";
    }
}
