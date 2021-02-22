package core.security;

import core.model.Role;
import core.model.User;
import core.service.UserService;
import java.util.Collections;
import java.util.stream.Collectors;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CinemaUserDetailsService implements UserDetailsService {
    private UserService userService;
    
    public CinemaUserDetailsService(UserService userService) {
        this.userService = userService;
    }
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Such user wasn't found!"));
        return org.springframework.security.core.userdetails.User
                        .withUsername(user.getEmail())
                        .password(user.getPassword())
                .roles(user.getUserRole().stream()
                        .map(Role::getRoleName)
                        .toArray(String[]::new)).build();
    }
}
