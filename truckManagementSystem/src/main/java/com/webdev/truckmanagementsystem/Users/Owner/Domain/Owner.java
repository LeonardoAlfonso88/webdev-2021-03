package com.webdev.truckmanagementsystem.Users.Owner.Domain;

import com.webdev.truckmanagementsystem.Shared.Domain.Ids.OwnerId;
import com.webdev.truckmanagementsystem.Users.Owner.Domain.ValueObjects.*;

import java.util.HashMap;

public class Owner {
    private OwnerId ownerId;
    private OwnerFirstName firstName;
    private OwnerLastName lastName;
    private OwnerIdentificationNumber identificationNumber;
    private OwnerPhone phone;
    private OwnerAge age;

    public Owner(OwnerId ownerId,
                 OwnerFirstName firstName,
                 OwnerLastName lastName,
                 OwnerIdentificationNumber identificationNumber,
                 OwnerPhone phone,
                 OwnerAge age) {
        this.ownerId = ownerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identificationNumber = identificationNumber;
        this.phone = phone;
        this.age = age;
    }

    public static Owner Create(OwnerId ownerId,
                 OwnerFirstName firstName,
                 OwnerLastName lastName,
                 OwnerIdentificationNumber identificationNumber,
                 OwnerPhone phone,
                 OwnerAge age) {

        Owner owner = new Owner(ownerId, firstName, lastName, identificationNumber, phone, age);
        //EVENTS
        return owner;
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
           put("id", ownerId.value());
            put("firstName", firstName.value());
            put("lastName", lastName.value());
            put("age", age.value());
            put("phone", phone.value());
            put("identificationNumber", identificationNumber.value());
        }};
    }
}
