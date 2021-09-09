package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Entities;

import java.util.HashMap;
import java.util.Objects;

public class TruckOwner {

    private String ownerId;
    private String firstName;
    private String lastName;
    private String identificationNumber;

    public TruckOwner(String ownerId, String firstName, String lastName, String identificationNumber) {
        this.ownerId = ownerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identificationNumber = identificationNumber;
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("fullName", fullName());
            put("identificationNumber", identificationNumber);
        }};
    }

    private String fullName() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TruckOwner that = (TruckOwner) o;
        return Objects.equals(ownerId, that.ownerId) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(identificationNumber, that.identificationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerId, firstName, lastName, identificationNumber);
    }
}
