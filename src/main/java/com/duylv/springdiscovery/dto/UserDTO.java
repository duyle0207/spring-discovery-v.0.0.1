package com.duylv.springdiscovery.dto;

import com.duylv.springdiscovery.entity.Home;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Set;

public class UserDTO {

    private Long id;

    private String username;

    private String password;

    private String name;

    private List<HomeDTO> homes;

    private Boolean haveHome;

    public UserDTO() {
    }

    public UserDTO(Long id, String username, String name, Boolean haveHomes) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.haveHome = haveHome;
    }

    public List<HomeDTO> getHomes() {
        return homes;
    }

    public void setHomes(List<HomeDTO> homes) {
        this.homes = homes;
    }

    public Boolean getHaveHome() {
        return haveHome;
    }

    public void setHaveHome(Boolean haveHome) {
        this.haveHome = haveHome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
}
