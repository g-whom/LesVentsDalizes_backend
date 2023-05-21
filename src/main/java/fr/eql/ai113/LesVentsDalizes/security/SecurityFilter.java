package fr.eql.ai113.LesVentsDalizes.security;

import fr.eql.ai113.LesVentsDalizes.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityFilter extends OncePerRequestFilter {

    private static final Logger logger = LogManager.getLogger();

    /** Injecté par le setter */
    private UserService userService;


    /// @OVERIDE ///

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
//            logger.info("\r\n >>>>>>>>> 1/5 [SecurityFilter > doFilterInternal]BEFORE : Voici la valeur de la requette HHTP > doFilterInternal : " +request.toString());
           String token = extractTokenFromHeader(request);
//            logger.info("\r\n >>>>>>>>> 2+/5 [SecurityFilter > doFilterInternal]BEFORE : Voici la valeur du token : "+token);

            //WIP : controle ephemere
            UserDetails user = userService.getUserFromJwt(token);
//            logger.info("\t\nToujours dans 3/5 [doFilterInternal]->[userService.getUserFromJwt(token)] UserDetails user : "+user);
            setPrincipalInSecurityContext(user);
//            logger.info("\t\nToujours dans 4/5 [doFilterInternal]->[userService.getUserFromJwt(token)], a ton atteint le setter ???");
        } catch (Exception e) {
//            logger.info("Impossible de trouver le token", e);
        }
        filterChain.doFilter(request, response);
    }

    private String extractTokenFromHeader(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null) {
            return bearerToken.substring(7);
        }
//        logger.info(">> [extractTokenFromHeader > extractTokenFromHeader] un souci surement");
        return null;
    }

    private void setPrincipalInSecurityContext(UserDetails user) {
//        logger.info("\t\r\nOn est dans >> setPrincipalInSecurityContext : \t\r\n");
//        logger.info(" et on va setter le contexte du token : \t\r\n");
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

//        logger.info("Voici ce que le token donne : "+token);
        SecurityContextHolder.getContext().setAuthentication(token);
//        logger.info("\t\r\n et essayons d'afficher le contexte de security : " +SecurityContextHolder.getContext().getAuthentication().toString());
    }

    /// SETTERS ///

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
