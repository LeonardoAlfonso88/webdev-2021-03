package com.webdev.truckmanagementsystem.Trucks.Truck.Infrastructure.Controllers;

import com.webdev.truckmanagementsystem.Trucks.Truck.Application.All.TruckAll;
import com.webdev.truckmanagementsystem.Trucks.Truck.Application.All.TruckAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/Truck")
public class AllTrucksGetController {

    @Autowired
    private TruckAll all;

    @GetMapping(value = "/")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        TruckAllResponse response = all.execute();
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

}
