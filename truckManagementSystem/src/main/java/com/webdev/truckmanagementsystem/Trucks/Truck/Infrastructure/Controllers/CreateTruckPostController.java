package com.webdev.truckmanagementsystem.Trucks.Truck.Infrastructure.Controllers;

import com.webdev.truckmanagementsystem.Trucks.Truck.Application.CreateTruck.TruckCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Truck")
public class CreateTruckPostController {

    @Autowired
    private TruckCreator creator;

    @PostMapping(value = "/")
    public ResponseEntity execute(@RequestBody TruckRequest request) {
        this.creator.execute(request.getTruckId(), request.getBrand(), request.getModelYear(), request.getPlate(),
                request.getColor(), request.getInsuranceValue(), request.getMechanicalDate(),
                request.getOwner());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    static class TruckRequest {

        private String truckId;
        private String brand;
        private int modelYear;
        private String plate;
        private String color;
        private Double insuranceValue;
        private String mechanicalDate;
        private String owner;

        public String getTruckId() {
            return truckId;
        }

        public void setTruckId(String truckId) {
            this.truckId = truckId;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public int getModelYear() {
            return modelYear;
        }

        public void setModelYear(int modelYear) {
            this.modelYear = modelYear;
        }

        public String getPlate() {
            return plate;
        }

        public void setPlate(String plate) {
            this.plate = plate;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Double getInsuranceValue() {
            return insuranceValue;
        }

        public void setInsuranceValue(Double insuranceValue) {
            this.insuranceValue = insuranceValue;
        }

        public String getMechanicalDate() {
            return mechanicalDate;
        }

        public void setMechanicalDate(String mechanicalDate) {
            this.mechanicalDate = mechanicalDate;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public TruckRequest() {

        }
    }
}
