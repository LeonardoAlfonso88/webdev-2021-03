package com.webdev.truckmanagementsystem.truckTests;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.webdev.truckmanagementsystem.Shared.Domain.Exceptions.UUIDNotValid;
import com.webdev.truckmanagementsystem.Trucks.Truck.Application.Create.TruckCreator;
import com.webdev.truckmanagementsystem.Trucks.Truck.Application.Find.TruckFinder;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions.TruckNotFound;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Ports.TruckRepository;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Truck;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.TruckBrand;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.TruckId;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.TruckModelYear;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.TruckPlate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class TruckTest {

    @Test
    void should_create_truck() {
        //Preparar el mock - implementación falsa
        TruckRepository repository = mock(TruckRepository.class);

        //Caso de uso
        TruckCreator creator = new TruckCreator(repository);

        //Data Falsa - Objeto Referencia
        Truck truck = new Truck(new TruckId("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa"), new TruckBrand("Ford"),
                new TruckModelYear(2000), new TruckPlate("FAA123"));

        //Ejecutar el caso de uso
        creator.execute("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa", "Ford", 2000, "FAA123");

        //Ejecutar
        verify(repository, atLeastOnce()).save(truck);
    }

    @Test
    void should_not_create_truck_by_not_value_uuid() {
        //Preparar el mock - implementación falsa
        TruckRepository repository = mock(TruckRepository.class);

        //Caso de uso
        TruckCreator creator = new TruckCreator(repository);

        Assertions.assertThrows(UUIDNotValid.class, () -> {
            creator.execute("9007ee55-d8eb-4d0c", "Ford", 2000, "FAA123");
        });
    }

    @Test
    void should_find_truck() {
        //Preparar el mock - implementación falsa
        TruckRepository repository = mock(TruckRepository.class);

        //Caso de uso
        TruckFinder finder = new TruckFinder(repository);

        //Data Falsa - Objeto Referencia
        Truck truck = new Truck(new TruckId("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa"), new TruckBrand("Ford"),
                new TruckModelYear(2000), new TruckPlate("FAA123"));

        //Configurar el mock
        Mockito.when(repository.find(new TruckId("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa"))).thenReturn(Optional.of(truck));

        //Verificación
        assertEquals(truck, finder.find("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa"));
    }

    @Test
    void should_not_find_truck() {
        //Preparar el mock - implementación falsa
        TruckRepository repository = mock(TruckRepository.class);

        //Caso de uso
        TruckFinder finder = new TruckFinder(repository);

        //Data Falsa - Objeto Referencia
        Truck truck = new Truck(new TruckId("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa"), new TruckBrand("Ford"),
                new TruckModelYear(2000), new TruckPlate("FAA123"));

        //Configurar el mock
        Mockito.when(repository.find(new TruckId("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa"))).thenReturn(Optional.of(truck));

        //Verificación
        Assertions.assertThrows(TruckNotFound.class, () -> {
            finder.find("21a5eb2d-7fa4-47f2-a304-ac39770cce56");
        });
    }
}
