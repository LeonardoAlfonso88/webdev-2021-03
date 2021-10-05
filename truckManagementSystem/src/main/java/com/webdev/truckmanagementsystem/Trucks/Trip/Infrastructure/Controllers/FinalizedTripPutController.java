package com.webdev.truckmanagementsystem.Trucks.Trip.Infrastructure.Controllers;

import com.webdev.truckmanagementsystem.Trucks.Trip.Application.Create.TripCreator;
import com.webdev.truckmanagementsystem.Trucks.Trip.Application.FinalizedTrip.TripFinalized;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Exceptions.TripAlreadyExist;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Exceptions.TripNotExist;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Tag(name = "Trip", description = "The Trip API")
@RequestMapping(value = "/Trip")
public class FinalizedTripPutController {

    @Autowired
    private TripFinalized finalized;

    @PutMapping(value = "/{id}")
    public ResponseEntity execute(@PathVariable("id") String id) {
        this.finalized.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(TripNotExist.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleTripAlreadyExist(TripNotExist exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

}
