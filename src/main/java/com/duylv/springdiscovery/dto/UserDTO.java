package com.duylv.springdiscovery.dto;

import com.duylv.springdiscovery.entity.Home;
import com.duylv.springdiscovery.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
public class UserDTO {

    private Long id;

    private String username;

    private String password;

    private Set<RoleDTO> roles;

    private Set<HomeDTO> homes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDTO> roles) {
        this.roles = roles;
    }

    public Set<HomeDTO> getHomes() {
        return homes;
    }

    public void setHomes(Set<HomeDTO> homes) {
        this.homes = homes;
    }
}
