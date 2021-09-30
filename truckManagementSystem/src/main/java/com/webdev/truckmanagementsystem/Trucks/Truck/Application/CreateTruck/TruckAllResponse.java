package com.webdev.truckmanagementsystem.Trucks.Truck.Application.CreateTruck;

import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Truck;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TruckAllResponse {

    private List<Truck> trucks;

    public TruckAllResponse(List<Truck> trucks) {
        this.trucks = trucks;
    }

    public List<HashMap<String, Object>> response() {
        List<HashMap<String, Object>> response = trucks.stream().map(element -> element.data()).collect(Collectors.toList());
        return response;
    }

}
