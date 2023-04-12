package fr.eql.ai113.LesVentsDalizes.controller.rest;

import fr.eql.ai113.LesVentsDalizes.entity.dto.AuthRequest;
import fr.eql.ai113.LesVentsDalizes.entity.dto.AuthResponse;
import fr.eql.ai113.LesVentsDalizes.service.impl.AccountExistsException;
import fr.eql.ai113.LesVentsDalizes.service.impl.UnauthorizedException;
import fr.eql.ai113.LesVentsDalizes.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("security")
@CrossOrigin(origins = "${front.url}")
public class SecurityRestController {

    Logger logger = LoggerFactory.getLogger(getClass());
    /** Injecté par le setter */
    UserService userService;
//http://localhost:8097/security/authorize
    @PostMapping("/authorize")
    public ResponseEntity<AuthResponse> authorize(@RequestBody AuthRequest requestDto) throws UnauthorizedException {
        Authentication authentication;
            logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\t\n\r\n");
        try {
            authentication = userService.authenticate(requestDto.getUsername(), requestDto.getPassword());
            logger.info(authentication.getName().toString());
            logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\t\n\r\n");
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails owner = (UserDetails) authentication.getPrincipal();
            String token = userService.generateJwtForUser(owner);
            return ResponseEntity.ok(new AuthResponse(owner, token));
        } catch (AuthenticationException e) {
            throw new UnauthorizedException();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest requestDto) throws AccountExistsException {
        UserDetails owner = userService.save(requestDto.getUsername(), requestDto.getPassword());
        String token  = userService.generateJwtForUser(owner);
        return ResponseEntity.ok(new AuthResponse(owner, token));
    }

    /// Setters ///
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
