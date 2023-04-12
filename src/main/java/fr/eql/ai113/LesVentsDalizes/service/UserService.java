package fr.eql.ai113.LesVentsDalizes.service;

import fr.eql.ai113.LesVentsDalizes.service.impl.AccountExistsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    Authentication authenticate(String username, String password) throws AuthenticationException;
    UserDetails save(String username, String password) throws AccountExistsException;
    String generateJwtForUser(UserDetails user);
    UserDetails getUserFromJwt(String jwt);
}
