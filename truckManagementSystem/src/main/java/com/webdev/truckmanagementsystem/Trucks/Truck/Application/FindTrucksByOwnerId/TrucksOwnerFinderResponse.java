package com.webdev.truckmanagementsystem.Trucks.Truck.Application.FindTrucksByOwnerId;

import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Truck;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TrucksOwnerFinderResponse {

    private List<Truck> trucks;

    public TrucksOwnerFinderResponse(List<Truck> trucks) {
        this.trucks = trucks;
    }

    public List<HashMap> response() {
        List<HashMap> response = trucks.stream().map(t -> t.data()).collect(Collectors.toList());
        response.stream().forEach(h -> h.remove("ownerId"));
        return response;
    }
}
