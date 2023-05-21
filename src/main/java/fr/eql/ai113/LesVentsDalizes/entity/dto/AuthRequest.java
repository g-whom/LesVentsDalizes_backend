package fr.eql.ai113.LesVentsDalizes.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.eql.ai113.LesVentsDalizes.entity.Address;
import fr.eql.ai113.LesVentsDalizes.entity.RequestPerform;
import fr.eql.ai113.LesVentsDalizes.entity.Role;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 This class corresponds to the login information of a user

 @Author : J.VENT

 */
public class AuthRequest {


    /**
     * Corresponds to the user's email
     */
    private String username;
    private String password;

    private Collection<Role> roles = new ArrayList<>();


    //// CONSTRUCTOR ////


    public AuthRequest() {
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public Collection<Role> getRoles() {
        return roles;
    }

    //// SETTERS  ////
//


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
    //// TOSTRING ////



    @Override
    public String toString() {
        return "AuthRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }

}
