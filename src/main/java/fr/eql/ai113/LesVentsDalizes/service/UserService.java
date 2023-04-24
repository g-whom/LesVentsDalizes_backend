package fr.eql.ai113.LesVentsDalizes.service;

import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.entity.Role;
import fr.eql.ai113.LesVentsDalizes.entity.dto.AuthRequest;
import fr.eql.ai113.LesVentsDalizes.exceptions.AccountExistsException;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentRoleException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    //OLD Authentication authenticate(String username, String password) throws AuthenticationException;
    Authentication authenticate(AuthRequest authRequest) throws AuthenticationException;
//   OLD UserDetails save(String username, String password) throws AccountExistsException;
//    UserDetails save(AuthRequest authRequest) throws AccountExistsException, NonExistentRoleException;
    UserDetails save(Customer customer) throws AccountExistsException, NonExistentRoleException;
    String generateJwtForUser(UserDetails user);
    UserDetails getUserFromJwt(String jwt);


   //oups  romJwt(String jwt);

    Role retrieveRole(Long id) throws NonExistentRoleException;
}
