package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Entities;

import java.util.HashMap;
import java.util.Objects;

public class TruckDriver {

    private String driverId;
    private String firstName;
    private String lastName;
    private String identificationNumber;
    private String licenseNumber;

    public TruckDriver(String driverId, String firstName, String lastName, String identificationNumber, String licenseNumber) {
        this.driverId = driverId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identificationNumber = identificationNumber;
        this.licenseNumber = licenseNumber;
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("fullName", fullName());
            put("identificationNumber", identificationNumber);
            put("licenseNumber", licenseNumber);
        }};
    }

    public HashMap<String, Object> dataDB() {
        return new HashMap<>() {{
            put("driverId", driverId);
            put("firstName", firstName);
            put("lastName", lastName);
            put("identificationNumber", identificationNumber);
            put("licenseNumber", licenseNumber);
        }};
    }

    private String fullName() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TruckDriver that = (TruckDriver) o;
        return Objects.equals(driverId, that.driverId) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(identificationNumber, that.identificationNumber) && Objects.equals(licenseNumber, that.licenseNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverId, firstName, lastName, identificationNumber, licenseNumber);
    }
}
