package com.duylv.springdiscovery.filter;

public class NumberFilter {

    private Number greaterThan;

    private Number greaterThanEqual;

    private Number lessThan;

    private Number lessThanEqual;

    public Number getGreaterThan() {
        return greaterThan;
    }

    public void setGreaterThan(Number greaterThan) {
        this.greaterThan = greaterThan;
    }

    public Number getGreaterThanEqual() {
        return greaterThanEqual;
    }

    public void setGreaterThanEqual(Number greaterThanEqual) {
        this.greaterThanEqual = greaterThanEqual;
    }

    public Number getLessThan() {
        return lessThan;
    }

    public void setLessThan(Number lessThan) {
        this.lessThan = lessThan;
    }

    public Number getLessThanEqual() {
        return lessThanEqual;
    }

    public void setLessThanEqual(Number lessThanEqual) {
        this.lessThanEqual = lessThanEqual;
    }
}
