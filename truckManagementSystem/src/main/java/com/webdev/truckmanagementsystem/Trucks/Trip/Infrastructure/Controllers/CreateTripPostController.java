package com.webdev.truckmanagementsystem.Trucks.Trip.Infrastructure.Controllers;

import com.webdev.truckmanagementsystem.Trucks.Trip.Application.Create.TripCreator;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Exceptions.*;
import com.webdev.truckmanagementsystem.Trucks.Trip.Infrastructure.Schema.ErrorSchema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Tag(name = "Trip", description = "The Trip API")
@RequestMapping(value = "/Trip")
public class CreateTripPostController {

    @Autowired
    private TripCreator creator;

    @Operation(summary = "Create a new Trip", description = "Create a new Trip", tags = {"Trip"})
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Trip created"),
        @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
        @ApiResponse(responseCode = "409", description = "Trip Already Exist", content = @Content(schema = @Schema(implementation = ErrorSchema.class)))
    })
    @PostMapping(value = "/")
    public ResponseEntity execute(@RequestBody TripRequest request) {
        this.creator.execute(request.getTripId(), request.getOrigin(), request.getDestiny(), request.getDistance(),
                request.getLoadWeight(), request.getInitialDate(), request.getPlannedFinalDate(),
                request.getTruckId());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(TripAlreadyExist.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handleTripAlreadyExist(TripAlreadyExist exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler({NotPositiveDistance.class, NotValidTripFormat.class, NotValidTripPlace.class, WeightOutRange.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequest(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    static class TripRequest {

        @Schema(description = "The Trip ID", example = "08dd2131-ece4-4616-a924-6308d62bc3be")
        private String tripId;

        @Schema(description = "The Trip origin", example = "BOG")
        private String origin;
        private String destiny;
        private double distance;
        private double loadWeight;
        private String initialDate;
        private String plannedFinalDate;
        private String realFinalDate;
        private String truckId;

        public String getTripId() {
            return tripId;
        }

        public void setTripId(String tripId) {
            this.tripId = tripId;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getDestiny() {
            return destiny;
        }

        public void setDestiny(String destiny) {
            this.destiny = destiny;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public double getLoadWeight() {
            return loadWeight;
        }

        public void setLoadWeight(double loadWeight) {
            this.loadWeight = loadWeight;
        }

        public String getInitialDate() {
            return initialDate;
        }

        public void setInitialDate(String initialDate) {
            this.initialDate = initialDate;
        }

        public String getPlannedFinalDate() {
            return plannedFinalDate;
        }

        public void setPlannedFinalDate(String plannedFinalDate) {
            this.plannedFinalDate = plannedFinalDate;
        }

        public String getRealFinalDate() {
            return realFinalDate;
        }

        public void setRealFinalDate(String realFinalDate) {
            this.realFinalDate = realFinalDate;
        }

        public String getTruckId() {
            return truckId;
        }

        public void setTruckId(String truckId) {
            this.truckId = truckId;
        }

        public TripRequest() {

        }
    }

}
