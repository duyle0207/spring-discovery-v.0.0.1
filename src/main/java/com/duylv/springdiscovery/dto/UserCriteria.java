package com.duylv.springdiscovery.dto;

import com.duylv.springdiscovery.filter.StringFilter;

import java.util.List;

public class UserCriteria {

    private StringFilter username;

    private StringFilter name;

    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

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
