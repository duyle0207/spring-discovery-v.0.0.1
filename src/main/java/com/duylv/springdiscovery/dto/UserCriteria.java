package com.duylv.springdiscovery.dto;

import com.duylv.springdiscovery.filter.StringFilter;

public class UserCriteria {

    private StringFilter username;

    private StringFilter name;

    public StringFilter getUsername() {
        return username;
    }

    public void setUsername(StringFilter username) {
        this.username = username;
    }

    public StringFilter getName() {
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }
}
