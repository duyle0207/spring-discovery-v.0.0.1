package com.duylv.springdiscovery.filter;

import java.util.Set;

public class BaseFilter {

    private Object equal;

    private Object notEqual;

    private Set<Object> in;

    private Set<Object> notIn;

    public Set<Object> getIn() {
        return in;
    }

    public void setIn(Set<Object> in) {
        this.in = in;
    }

    public Set<Object> getNotIn() {
        return notIn;
    }

    public void setNotIn(Set<Object> notIn) {
        this.notIn = notIn;
    }

    public Object getEqual() {
        return equal;
    }

    public void setEqual(Object equal) {
        this.equal = equal;
    }

    public Object getNotEqual() {
        return notEqual;
    }

    public void setNotEqual(Object notEqual) {
        this.notEqual = notEqual;
    }
}
