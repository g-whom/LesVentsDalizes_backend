package fr.eql.ai113.LesVentsDalizes.entity.dto;


import fr.eql.ai113.LesVentsDalizes.entity.RequestPerform;
import fr.eql.ai113.LesVentsDalizes.entity.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *  This class represents the essential information associated with a client for the front-end microservice
 *
 * @Author: J.VENT
 */
public class CustomerConnectDto implements UserDetails {

    private Long id;
    private String name;
    private String surname;
    private String username;
    private List<RequestPerform> requestPerformList = new ArrayList<>();
    private Collection<Role> roles = new ArrayList<>();


    /// CONSTRUCTOR ///

    public CustomerConnectDto() {
    }

    public CustomerConnectDto(Long id, String name, String surname, String username) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
    }

    public CustomerConnectDto(Long id, String name, String surname, String username, Collection<Role> roles) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.roles = roles;
    }

    /// METHODS ///


    /// @OVERRIDE ///

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return null;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    /// GETTER ///

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    public String getUsername() {
        return username;
    }


    public List<RequestPerform> getRequestPerformList() {
        return requestPerformList;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    /// SETTER ///

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRequestPerformList(List<RequestPerform> requestPerformList) {
        this.requestPerformList = requestPerformList;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    /// TO_STRING ///
}
