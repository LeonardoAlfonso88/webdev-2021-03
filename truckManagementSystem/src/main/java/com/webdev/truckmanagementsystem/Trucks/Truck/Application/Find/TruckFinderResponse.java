package com.webdev.truckmanagementsystem.Trucks.Truck.Application.Find;

import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Truck;

import java.util.HashMap;

public class TruckFinderResponse {

    private Truck truck;

    public TruckFinderResponse(Truck truck) {
        this.truck = truck;
    }

    public HashMap response() {
        HashMap data = truck.data();
        data.remove("insuranceValue");
        return data;
    }
}
