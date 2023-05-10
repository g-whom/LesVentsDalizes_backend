package fr.eql.ai113.LesVentsDalizes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private DataSource dataSource;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public SecurityFilter securityFilter() {
        return new SecurityFilter();
    }

    ///WIP je
//    @Override
//    protected  void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
////                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                //                .usersByUsernameQuery("SELECT email, password FROM customers WHERE email =? AND password =?")
//                .passwordEncoder(passwordEncoder())
//                .usersByUsernameQuery("SELECT email, password FROM customers WHERE email = ?")
//                .authoritiesByUsernameQuery("SELECT c.email, r.role FROM customers c JOIN customers_roles cr ON c.id = cr.customer_id JOIN roles r ON cr.roles_id = r.id WHERE c.email =?");
//               // .authoritiesByUsernameQuery("SELECT c.email, r.role FROM customers c JOIN customers_roles cr ON c.id = cr.customer_id JOIN roles r ON cr.roles_id = r.id WHERE c.email =?");
//    }

    //WIP je

//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Activation du CORS, désactivation du CSRF
        http = http.cors().and().csrf().disable();

        // Gestion de session en stateless
        http = http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();

        // Gestion des requêtes non autorisées
        http = http
                .exceptionHandling()
                .authenticationEntryPoint(new SecurityEntryPoint())
                .and();

        // Permissions sur les point d'API
        http


                .authorizeRequests()
                // Points publics
                .antMatchers("/security/**").permitAll()
                .antMatchers("/customers/**").hasRole("USER") //.permitAll()
                //.antMatchers("/events/**").permitAll()
                .antMatchers("/events/**").hasRole("USER")
                .anyRequest().authenticated() ;//BONUS
        //                .antMatchers("/events/**").hasAnyAuthority("ROLE_USER");
//                .and()
//                .formLogin()
//                .and()
//                .httpBasic();


        http.addFilterBefore(securityFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}

/*
//                .antMatchers("events/**").hasAnyAuthority("'ROLE_USER', 'USER', 'ROLE_SUPER_ADMIN', 'SUPER_ADMIN'")
                //.antMatchers("/events/show/all").hasAnyAuthority("ROLE_USER")
//                .antMatchers("/events/**").hasAnyAuthority("ROLE_USER", "USER", "ROLE_SUPER_ADMIN", "SUPER_ADMIN")
//                .antMatchers("/events/**").permitAll()
//                .antMatchers("/events/**").access("hasRole('SUPER_ADMIN')")
                //.antMatchers("/events/**").hasAnyAuthority("USER")
//                .antMatchers("/events/**").hasAnyAuthority("ROLE_USER")
               // .antMatchers("/events/**").hasRole("SUPER_ADMIN")
                // eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqZXJvaWVwZnBtYWwudG9uaXlAY25yczJVLmZyIiwiaWF0IjoxNjgyMjA2MDgzLCJleHAiOjE2ODIyMDk2ODN9.u1q_6-K5b2Wb9tD5_v5Rg071MD9EReI1k2_zYRJnFTTazPKf37RnfLj05qslOIMOpWTUbBHFXYJMPSiB69J12w
                 //  eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqZXJvaWVwZnBtYWwudG9uaXlAY25yczJVLmZyIiwiaWF0IjoxNjgyMjA2MDgzLCJleHAiOjE2ODIyMDk2ODN9.u1q_6-K5b2Wb9tD5_v5Rg071MD9EReI1k2_zYRJnFTTazPKf37RnfLj05qslOIMOpWTUbBHFXYJMPSiB69J12w
//                .antMatchers("/events/**").hasRole("USER")
//                .antMatchers("events/**").hasAuthority("ROLE_USER")

                // Points privés
 */