package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Ports;

import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.TruckColor;

public interface TruckColorValidator {
    Boolean validateColor(TruckColor color);
}
