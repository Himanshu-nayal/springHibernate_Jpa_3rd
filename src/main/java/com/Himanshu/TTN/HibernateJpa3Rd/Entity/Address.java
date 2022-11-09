package com.Himanshu.TTN.HibernateJpa3Rd.Entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable

public class Address {
    private int StreetNumber;
    private String location;
    private String state;

    public int getStreetNumber() {
        return StreetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        StreetNumber = streetNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
