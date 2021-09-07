package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Ports;

import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Truck;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.TruckId;

import java.util.List;
import java.util.Optional;

public interface TruckRepository {
    void save(Truck truck);
    Optional<Truck> find(TruckId Id);
}
