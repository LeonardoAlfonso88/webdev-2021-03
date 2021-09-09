package com.webdev.truckmanagementsystem.Trucks.Truck.Application.Find;

import com.webdev.truckmanagementsystem.Shared.Domain.Ids.OwnerId;
import com.webdev.truckmanagementsystem.Shared.Domain.Ids.TruckId;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions.TruckNotFound;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Ports.TruckRepository;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Truck;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TruckFinderTest {

    Truck truck;
    TruckRepository repository;

    @BeforeEach
    void setup() {
        //Data Falsa - Objeto Referencia
        this.truck = new Truck(new TruckId("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa"),
                new TruckBrand("Ford"),
                new TruckModelYear(2000),
                new TruckPlate("FAA123"),
                new TruckColor("#454545"),
                new TruckInsuranceValue(500000d),
                new TruckMechanicalRevisionDate("05-05-2018"),
                new TruckTotalDistance(0d),
                new OwnerId("6543fbcf-fe01-4c25-a851-a8c46ac38f27"), null, null);

        //Preparar el mock - implementación falsa
        this.repository = mock(TruckRepository.class);

        //Configurar el mock
        Mockito.when(repository.find(new TruckId("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa"))).thenReturn(Optional.of(truck));
    }

    @Test
    void should_find_truck() {
        //Caso de uso
        TruckFinder finder = new TruckFinder(repository);

        //Verificación
        assertEquals(truck, finder.execute("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa"));
    }

    @Test
    void should_not_find_truck() {
        //Caso de uso
        TruckFinder finder = new TruckFinder(repository);

        //Verificación
        Assertions.assertThrows(TruckNotFound.class, () -> {
            finder.execute("21a5eb2d-7fa4-47f2-a304-ac39770cce56");
        });
    }
}